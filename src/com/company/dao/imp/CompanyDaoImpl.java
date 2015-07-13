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

    //������� �� ������ ����� sql �����
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

    // ������� ������� ����� ������ ��
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

    // ������� ������� ����� ������ �� HQL
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
