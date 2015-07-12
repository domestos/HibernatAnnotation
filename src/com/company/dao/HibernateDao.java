package com.company.dao;

import com.company.Company;
import com.company.DataBase;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by v.pelenskyi on 08.07.2015.
 */
public interface HibernateDao {

    public void  addDataBase(DataBase dataBase) throws SQLException;

    public void deleteDataBase(DataBase dataBase) throws SQLException;

    public Company getIdDataBase(int id) throws SQLException;

    public List<Company> getAllDataBase() throws SQLException;
}
