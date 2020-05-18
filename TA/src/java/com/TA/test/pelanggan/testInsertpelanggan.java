/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TA.test.pelanggan;

import com.TA.Dao.impl.pelangganDaoImpl;
import com.TA.enkripsi.AES;
import com.TA.models.pelanggan;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author teguh
 */
public class testInsertpelanggan {
    
    public static void main(String []args) throws SQLException{
    
        pelanggan plu = new pelanggan();
        pelangganDaoImpl insert = new pelangganDaoImpl();
        
        int a = insert.autonumber(plu);
        
        String pelanggan_nama, pelanggan_alamat, pelanggan_nohp, pelanggan_email,pelanggan_pekerjaan;
         Scanner keyboard = new Scanner(System.in);
         System.out.print("Nama : "); 
         pelanggan_nama = keyboard.nextLine();

         Scanner keyboard2 = new Scanner(System.in);
         System.out.print("alamat: ");
         pelanggan_alamat = keyboard2.nextLine();

         Scanner keyboard3 = new Scanner(System.in);
         System.out.print("no telp: ");
         pelanggan_nohp = keyboard2.nextLine();
         
         Scanner keyboard4 = new Scanner(System.in);
         System.out.print("email: ");
         pelanggan_email = keyboard2.nextLine();
         
         Scanner keyboard5 = new Scanner(System.in);
         System.out.print("pekerjaan: ");
         pelanggan_pekerjaan = keyboard2.nextLine();
         
        
         plu.setId_pelanggan(a);
         plu.setPelanggan_nama(AES.encrypt(pelanggan_nama));
         plu.setPelanggan_alamat(AES.encrypt(pelanggan_alamat));
         plu.setPelanggan_nohp(AES.encrypt(pelanggan_nohp));
         plu.setPelanggan_email(AES.encrypt(pelanggan_email));
         plu.setPelanggan_pekerjaan(AES.encrypt(pelanggan_pekerjaan));
         
         
         int status = insert.insert(plu);
         
         if (status == 0){
             System.out.println("data gagal di input");
         
         }else{
         
             System.out.println("data berhasi di input");
         }
    }
    
}
