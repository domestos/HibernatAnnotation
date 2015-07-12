package com.company;

import com.company.dao.HibernateDao;
import com.company.dao.imp.CartrigeDaoImpl;
import com.company.dao.imp.CompanyDaoImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
	// write your code here

        CompanyDaoImpl companyDaoImpl= new CompanyDaoImpl();
        CartrigeDaoImpl cartrigeDaoImpl = new CartrigeDaoImpl();

        Company company = new Company();
        company.setNameCompany("DZK Company");
        company.setMobCumber("0676724468");

        //ADD
        //-----------------------------------------------------------
        //companyDaoImpl.addDataBase(company);
        //-----------------------------------------------------------

        //GET ALL
        //-----------------------------------------------------------

        List<Company> companies = companyDaoImpl.getAllDataBase();
        System.out.println("Get all company: " );
        for (Company com: companies){
            System.out.println(com.getId()+" "+
                    com.getMobCumber()+" "+
                    com.getNameCompany()+" ");
        }
        //-------------------------------------------------------------

/*
        //GET ID
        //-----------------------------------------------------------
        Company returnGetId =  companyDaoImpl.getIdDataBase(1);
        System.out.println("Get id company: " );
        System.out.println(returnGetId.getId()+" "+
                returnGetId.getMobCumber()+" "+
                returnGetId.getNameCompany()+" ");

        //-----------------------------------------------------------

        //DELETE
        //-----------------------------------------------------------
        companyDaoImpl.deleteDataBase(returnGetId);
        //-----------------------------------------------------------
        */
        System.out.println( companyDaoImpl.getNameDataBase("DZK Company"));

    }
}
