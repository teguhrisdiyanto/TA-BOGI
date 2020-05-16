/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TA.test.pelanggan;

import com.TA.Dao.impl.pelangganDaoImpl;
import com.TA.models.pelanggan;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author teguh
 */
public class tesGetId {
    
    public static void main(String[]args) throws SQLException{
    pelanggan pl = new pelanggan();
    int id;  
     Scanner keyboard = new Scanner(System.in);
     System.out.print("id: ");
     id = Integer.parseInt(keyboard.nextLine());
     
     
     
     pelangganDaoImpl plgetid = new pelangganDaoImpl();
     pl = plgetid.getbyid(id);
     
     
     int idpel = pl.getId_pelanggan();
     String nama = pl.getPelanggan_nama();
     String alamat = pl.getPelanggan_alamat();
     String nohp = pl.getPelanggan_nohp();
     String email = pl.getPelanggan_email();
     String pekerjaan = pl.getPelanggan_pekerjaan();
     
     
        System.out.println("ini id :" + idpel);
        System.out.println("ini nama :" + nama);
        System.out.println("ini alamat :" + alamat);
        System.out.println("ini nohp :" + nohp);
        System.out.println("ini email :" + email);
        System.out.println("ini pekerjaan :" + pekerjaan);
    
    
    }
    
}
