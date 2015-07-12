package com.company.dao.imp;

import com.company.Company;
import com.company.DataBase;
import com.company.dao.HibernateDao;
import com.company.util.HibernatUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by v.pelenskyi on 08.07.2015.
 */
public class CompanyDaoImpl implements HibernateDao {

    @Override
    public void addDataBase(DataBase dataBase) throws SQLException {
        //сворюємо сесію
        Session session = null;

        try {
            //session = HibernatUtil.getSessionFactory() - об"єкт який містить конфігураційні дані SQL
            //HibernatUtil.getSessionFactory().openSession() - застосовуємо метод який відкриває (запускає) сесію
            session = HibernatUtil.getSessionFactory().openSession();
            //відкриваємо транзакцію
            Transaction transaction = session.beginTransaction();
            //зберігаємо те, те що передали
            session.save(dataBase);
            // зафіксували зміни
            transaction.commit();
        }finally {
            closeSession(session);
        }
    }

    @Override
    public void deleteDataBase(DataBase  dataBase) throws SQLException {

        Session session = null;

        try {
            session = HibernatUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(dataBase);
            transaction.commit();
        } finally {
            closeSession(session);
        }
    }

    @Override
    public Company getIdDataBase(int id) throws SQLException {
        Company result =null;
        Session session = null;
        try {
            session = HibernatUtil.getSessionFactory().openSession();
            //session.load - приймає параметр класТаблиця:)
            // і поле по якому слід зробити вибірку
            // метод повертає обєк! тосу слід привести його до того обєкту якому він відноситься (Company)
            result = (Company) session.get(Company.class, id); //якщо нічого не верене треба поміняти load на get тому, що сесія закривається швидше ніж файл повертається
        }finally {
            closeSession(session);
        }
        return result;
    }


    //метод, що повертає всі значення в таблиці
    @Override
    public List<Company> getAllDataBase() throws SQLException {
        List<Company> company = null;
        Session session = null;
        try {
            session = HibernatUtil.getSessionFactory().openSession();
            // у відкритій сесії запускається метод createCriteria в який ми передаємо обєкТаблиця
            // метод повертає нам обєкт класу Criteria  в якому є метол list
            // а list  повертає список свіх строк(критерій які були цьому обєкті)
            company = session.createCriteria(Company.class).list();
        }finally {
            closeSession(session);
        }
        return company;
    }

    public void testMethod(){

    }

    private void closeSession(Session session) {
        if ((session != null) && (session.isOpen())) {
            session.close();
        }
    }
}
