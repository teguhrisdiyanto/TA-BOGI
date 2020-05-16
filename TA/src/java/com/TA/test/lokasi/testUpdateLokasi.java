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
public class testUpdateLokasi {
    
    public static void main(String[]args) throws SQLException{
    
    lokasi lok = new lokasi();
        lokasiDaoImpl update = new lokasiDaoImpl();
        
         int id;
         Scanner keyboard10 = new Scanner(System.in);
         System.out.print("id: ");
         id = Integer.parseInt(keyboard10.nextLine());
        
       
        
        String nama_lokasi;
         Scanner keyboard = new Scanner(System.in);
         System.out.print("Nama : "); 
         nama_lokasi = keyboard.nextLine();
         
         lok.setId_lokasi(id);
         lok.setLokasi_namalokasi(nama_lokasi);
         
         int i =  update.update(lok);
    if (i == 0){
        System.out.println("data gagal di update");
    
    }else{
    
        System.out.println("data berhasil di update" );
    
    }
    
    
    }
    
}
