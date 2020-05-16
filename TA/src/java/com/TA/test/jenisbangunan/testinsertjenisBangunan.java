/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TA.test.jenisbangunan;

import com.TA.Dao.impl.jenisBangunanDaoImpl;
import com.TA.models.jenisBangunan;
import com.TA.models.lokasi;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author teguh
 */
public class testinsertjenisBangunan {
    
    public static void main(String []args) throws SQLException{
     jenisBangunan jen = new jenisBangunan();
        jenisBangunanDaoImpl insert = new jenisBangunanDaoImpl();
        
        int a = insert.autonumber(jen);
        
        String nama_jenis;
         Scanner keyboard = new Scanner(System.in);
         System.out.print("Nama_jen: "); 
         nama_jenis = keyboard.nextLine();
         
          jen.setId_jenisbangun(a);
         jen.setJenisbangun_nama(nama_jenis);
         
         int status = insert.insert(jen);
         
         if(status == 0){
             System.out.println("data gagal di insert");
         
         }else{
             System.out.println("data berhasil di insert");
         
         
         }
    
    }
    
}
