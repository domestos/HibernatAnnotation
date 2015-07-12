package com.company.dao.imp;

import com.company.Company;
import com.company.dao.HibernateDao;
import com.company.DataBase;
import com.company.util.HibernatUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by v.pelenskyi on 09.07.2015.
 */
public class CartrigeDaoImpl implements HibernateDao {


    private void closeSession(Session session) {
        if ((session != null) && (session.isOpen())) {
            session.close();
        }
    }

    @Override
    public void addDataBase(DataBase dataBase) throws SQLException {
        //�������� ����
        Session session = null;

        try {
            //session = HibernatUtil.getSessionFactory() - ��"��� ���� ������ ������������� ��� SQL
            //HibernatUtil.getSessionFactory().openSession() - ����������� ����� ���� ������� (�������) ����
            session = HibernatUtil.getSessionFactory().openSession();
            //��������� ����������
            Transaction transaction = session.beginTransaction();
            //�������� ��, �� �� ��������
            session.save(dataBase);
            // ����������� ����
            transaction.commit();
        }finally {
            closeSession(session);
        }
    }

    @Override
    public void deleteDataBase(DataBase dataBase) throws SQLException {
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
        return null;
    }

    @Override
    public List<Company> getAllDataBase() throws SQLException {
        return null;
    }
}
