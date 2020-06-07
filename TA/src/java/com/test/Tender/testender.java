/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.Tender;

import com.TA.Dao.impl.tenderDaoImpl;
import com.google.gson.Gson;
import java.sql.SQLException;

/**
 *
 * @author teguh
 */
public class testender {
    
    public static void main(String [] args) throws SQLException{
    Gson gson = new Gson();
        
        tenderDaoImpl tnd = new tenderDaoImpl();
        
        System.out.println("ini hasil : " + gson.toJson(tnd.getbyid(1)));
    
    }
    
}
