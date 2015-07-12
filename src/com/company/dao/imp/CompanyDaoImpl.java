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
            //session.load - ������ �������� �����������:)
            // � ���� �� ����� ��� ������� ������
            // ����� ������� ���! ���� ��� �������� ���� �� ���� ����� ����� �� ���������� (Company)
            result = (Company) session.get(Company.class, id); //���� ����� �� ������ ����� ������� load �� get ����, �� ���� ����������� ������ �� ���� �����������
        }finally {
            closeSession(session);
        }
        return result;
    }


    //�����, �� ������� �� �������� � �������
    @Override
    public List<Company> getAllDataBase() throws SQLException {
        List<Company> company = null;
        Session session = null;
        try {
            session = HibernatUtil.getSessionFactory().openSession();
            // � ������� ��� ����������� ����� createCriteria � ���� �� �������� ����������
            // ����� ������� ��� ���� ����� Criteria  � ����� � ����� list
            // � list  ������� ������ ��� �����(������� �� ���� ����� ����)
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
