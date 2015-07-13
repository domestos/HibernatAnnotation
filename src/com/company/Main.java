package com.company;

import com.company.dao.HibernateDao;
import com.company.dao.imp.CartrigeDaoImpl;
import com.company.dao.imp.CompanyDaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws SQLException {
	// write your code here
        
        
        
        CompanyDaoImpl companyDaoImpl= new CompanyDaoImpl();
        CartrigeDaoImpl cartrigeDaoImpl = new CartrigeDaoImpl();

/*
        List<Cartridge> cartridgeList = null;
        Company company = new Company();

        Cartridge cartridge = new Cartridge();
        cartridge.setCompany(company);
        cartridge.setModelCartridge("Samsun scx-4600");
        cartridge.setNumberLink("1659");
        cartridge.setRqLink("RQLink");

        Cartridge cartridge2 = new Cartridge();
        cartridge2.setCompany(company);
        cartridge2.setModelCartridge("Samsun scx-4600");
        cartridge2.setNumberLink("1659");
        cartridge2.setRqLink("RQLink");

        company.setCartridges(cartridgeList);
        company.setNameCompany("DZK Company");
        company.setMobCumber("0676724468");

        //ADD Company and create List<Cartridge>
        //-----------------------------------------------------------
        cartrigeDaoImpl.addDataBase(cartridge);
        cartrigeDaoImpl.addDataBase(cartridge2);
        // companyDaoImpl.addDataBase(company);
        //-----------------------------------------------------------
        //GET ALL
        //-----------------------------------------------------------
        List<Company> companies = companyDaoImpl.getAllDataBase();
        System.out.println("Get all company: " );
        companyDaoImpl.printListCompany(companies);
        //-------------------------------------------------------------

        //GET ALL SQLQuvery
        //-------------------------------------------------------------
        List<Company> companiesSQLQuvery =  companyDaoImpl.getSqlQueryAllCompany();
        System.out.println("Get companiesSQLQuvery All : " );
        companyDaoImpl.printListCompany(companiesSQLQuvery);
        //-------------------------------------------------------------

        //GET ID SQLQvery
        //-------------------------------------------------------------
        List<Company> companiesSQLQuveryID = companyDaoImpl.getSQLQuveryID(13);
        System.out.println("Get SQLQuvery ID: " );
        companyDaoImpl.printListCompany(companiesSQLQuveryID);
        //-------------------------------------------------------------

        //GET ID HQL
        //-------------------------------------------------------------
        System.out.println("Get ID HQL  " );
        List<Company> companyHQLID = companyDaoImpl.getHQLID(19);
        //-------------------------------------------------------------
 */       //GET OneToMany
        //-------------------------------------------------------------
        System.out.println("OneToMany HQL");
        companyDaoImpl.getOneToMany();

        //-------------------------------------------------------------
/*
        //GET ID
        //-----------------------------------------------------------
        Company returnGetId =  companyDaoImpl.getIdDataBase(12);
        System.out.println("Get id company: " );
        System.out.println(returnGetId.getId()+" "+
                returnGetId.getMobCumber()+" "+
                returnGetId.getNameCompany()+" ");

        //-----------------------------------------------------------


        //DELETE
        //-----------------------------------------------------------
        companyDaoImpl.deleteDataBase(returnGetId);


        if(!companyHQLID.isEmpty() && companyHQLID.size() == 1){
            System.out.println("You delete this object");
            Company comp = companyHQLID.get(0);
            System.out.println(comp.getId()+" = id " +
                    comp.getNameCompany()+" = name ");
            companyDaoImpl.deleteDataBase(comp);
        }else{
            System.out.println("this object empty");
        }
        //-----------------------------------------------------------
*/

    }




}
