package com.company.dao.imp;

import com.company.Company;
import com.company.dao.HibernateDao;
import com.company.DataBase;
import org.hibernate.Session;

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

    }

    @Override
    public void deleteDataBase(DataBase dataBase) throws SQLException {

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
