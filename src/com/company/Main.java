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

        //ADD
        //-----------------------------------------------------------
        companyDaoImpl.addDataBase(company);
        //-----------------------------------------------------------
        cartrigeDaoImpl.addDataBase(cartridge);
        cartrigeDaoImpl.addDataBase(cartridge2);
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


        //GET ID
        //-----------------------------------------------------------
        Company returnGetId =  companyDaoImpl.getIdDataBase(9);
        System.out.println("Get id company: " );
        System.out.println(returnGetId.getId()+" "+
                returnGetId.getMobCumber()+" "+
                returnGetId.getNameCompany()+" ");

        //-----------------------------------------------------------

        //DELETE
        //-----------------------------------------------------------
        companyDaoImpl.deleteDataBase(returnGetId);
        //-----------------------------------------------------------


    }
}
