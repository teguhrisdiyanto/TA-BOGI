/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TA.test.jenisbangunan;

import com.TA.Dao.impl.jenisBangunanDaoImpl;
import com.TA.test.lokasi.*;
import com.TA.Dao.impl.lokasiDaoImpl;
import com.TA.models.jenisBangunan;
import com.TA.models.lokasi;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author teguh
 */
public class testUpdatejenisBangunan {
    
    public static void main(String[]args) throws SQLException{
    
    jenisBangunan jen = new jenisBangunan();
        jenisBangunanDaoImpl update = new jenisBangunanDaoImpl();
        
         int id;
         Scanner keyboard10 = new Scanner(System.in);
         System.out.print("id: ");
         id = Integer.parseInt(keyboard10.nextLine());
        
       
        
        String nama_jenis;
         Scanner keyboard = new Scanner(System.in);
         System.out.print("Nama : "); 
         nama_jenis = keyboard.nextLine();
         
         jen.setId_jenisbangun(id);
         jen.setJenisbangun_nama(nama_jenis);
         
         int i =  update.update(jen);
    if (i == 0){
        System.out.println("data gagal di update");
    
    }else{
    
        System.out.println("data berhasil di update" );
    
    }
    
    
    }
    
}
