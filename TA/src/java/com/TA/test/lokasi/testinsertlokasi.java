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
public class testinsertlokasi {
    
    public static void main(String []args) throws SQLException{
     lokasi lok = new lokasi();
        lokasiDaoImpl insert = new lokasiDaoImpl();
        
        int a = insert.autonumber(lok);
        
        String nama_lok;
         Scanner keyboard = new Scanner(System.in);
         System.out.print("Nama_lok : "); 
         nama_lok = keyboard.nextLine();
         
          lok.setId_lokasi(a);
         lok.setLokasi_namalokasi(nama_lok);
         
         int status = insert.insert(lok);
         
         if(status == 0){
             System.out.println("data gagal di insert");
         
         }else{
             System.out.println("data berhasil di insert");
         
         
         }
    
    }
    
}
