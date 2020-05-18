/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TA.test.lokasi;


import com.TA.Dao.impl.lokasiDaoImpl;
import com.TA.models.lokasi;
import java.sql.SQLException;
import java.util.Scanner;


/**
 *
 * @author teguh
 */
public class getidlokasi {
    public static void main(String[] args) throws SQLException{
      lokasi lok = new lokasi();
    int id;  
    
     Scanner keyboard = new Scanner(System.in);
     System.out.print("id: ");
     id = Integer.parseInt(keyboard.nextLine());
     
     
     
     lokasiDaoImpl lokas = new lokasiDaoImpl();
     lok = lokas.getbyid(id);
     
     
     int idpelok =  lok.getId_lokasi();
     String namalokasi = lok.getLokasi_namalokasi();
   
     
     
        System.out.println("ini id :" + idpelok);
        System.out.println("ini nama :" + namalokasi);
        
    
    
    
    
    }
}
