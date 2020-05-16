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
import com.sun.istack.internal.Pool.Impl;
import java.sql.SQLException;
import java.util.Scanner;


/**
 *
 * @author teguh
 */
public class getidjenisBangunan {
    public static void main(String[] args) throws SQLException{
      jenisBangunan jenis = new jenisBangunan();
    int id;  
    
     Scanner keyboard = new Scanner(System.in);
     System.out.print("id: ");
     id = Integer.parseInt(keyboard.nextLine());
     
     
     
     jenisBangunanDaoImpl jen = new jenisBangunanDaoImpl();
     jenis = jen.getbyid(id);
     
     
     int idjen =  jenis.getId_jenisbangun();
     String namalokasi = jenis.getJenisbangun_nama();
   
     
     
        System.out.println("ini id :" + idjen);
        System.out.println("ini nama :" + namalokasi);
        
    
    
    
    
    }
}
