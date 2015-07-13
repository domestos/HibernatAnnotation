package com.company.dao.imp;

import com.company.Company;
import com.company.DataBase;
import com.company.dao.HibernateDao;
import com.company.util.HibernatUtil;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

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

    //вивести усі компанії через sql запит
    public List<Company> getSqlQueryAllCompany() throws SQLException {
        List<Company> resultList  = null;
        Session session = null;
        try{
            session = HibernatUtil.getSessionFactory().openSession();
            SQLQuery query = session.createSQLQuery("SELECT * FROM Company").addEntity(Company.class);
            resultList = query.list();
            return resultList ;
        }finally {
            closeSession(session);
        }
    }

    // вивести компанію через задане ід
    public List<Company> getSQLQuveryID(int paramID)throws SQLException {
        List<Company> result = null;
        Session session = null;

        try{
            session=HibernatUtil.getSessionFactory().openSession();
            SQLQuery quvery = (SQLQuery) session.createSQLQuery("SELECT * FROM Company c WHERE c.id = :paramID").addEntity(Company.class).setParameter("paramID", paramID);
            result= quvery.list();
        }finally {
            closeSession(session);
        }

        return  result;
    }

    // вивести компанію через задане ід HQL
    public List<Company> getHQLID(int paramID)throws SQLException {
        List<Company> result = null;
        Session session = null;

        try{
            session=HibernatUtil.getSessionFactory().openSession();
            Criteria cr = session.createCriteria(Company.class);
            cr.add(Restrictions.eq("id", paramID));
            result = cr.list();
            }finally {
            closeSession(session);
        }
        return  result;
    }
    //GET OneToMany
    public void getOneToMany()throws SQLException  {
        Session session = HibernatUtil.getSessionFactory().openSession();
      try{

          SQLQuery query = session.createSQLQuery("SELECT name_company, mob_number, car.model_cartridge, car.number_link, car.rq_link" +
                  " FROM Company  comp " +
                  "INNER JOIN Cartridge car ON car.id_company = comp.id ");

        List<DataBase []> resultObj = query.list();
        for (Object [] obj: resultObj){
            for(Object ob: obj){
                System.out.print(ob + " ");
            }
            System.out.println();
        }
      }finally {
          closeSession(session);
      }
    }


    public void printListCompany(List<Company> companyList){
        for (Company com: companyList){
            System.out.println(com.getId()+" "+
                    com.getMobCumber()+" "+
                    com.getNameCompany()+" ");
        }
    }



    private void closeSession(Session session) throws SQLException {
        if ((session != null) && (session.isOpen())) {
            session.close();
        }
    }
}
