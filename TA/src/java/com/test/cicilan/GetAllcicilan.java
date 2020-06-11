/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.cicilan;

import com.TA.Dao.impl.cicilanDaoImpl;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author teguh
 */
public class GetAllcicilan {
    
    public static void main(String []args) throws SQLException{
    
        Gson gson = new Gson();
        int id_tender,id_pelangaan,id_jenisbangun,id_lokasi;
         
         Scanner keyboard11 = new Scanner(System.in);
         System.out.print("select tender: ");
         id_tender = keyboard11.nextInt();
         
      cicilanDaoImpl cil = new cicilanDaoImpl();
      
        System.out.println("hasil :"+ gson.toJson(cil.getAll(id_tender)));
         
    
    }
    
}
