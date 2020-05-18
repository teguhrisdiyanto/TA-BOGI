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
import java.util.List;

/**
 *
 * @author teguh
 */
public class testGetAll {
    public static void main(String []args) throws SQLException{
        pelangganDaoImpl pu = new pelangganDaoImpl();
        
        
           pelanggan png = new pelanggan();
                            List<pelanggan> list;
                          
                           list = pu.getAll();
                              for (pelanggan pl : list) {
                                
                                png.setId_pelanggan(pl.getId_pelanggan());            
                                
                                png.setPelanggan_nama(AES.decrypt(pl.getPelanggan_nama()));
                                png.setPelanggan_alamat(pl.getPelanggan_alamat());
                                png.setPelanggan_nohp(pl.getPelanggan_nohp());
                                png.setPelanggan_email(pl.getPelanggan_email());
                                png.setPelanggan_pekerjaan(pl.getPelanggan_pekerjaan());
                                
                           
//                           
                            }
                                list.add(png);
    
                                System.out.println("ini list" + list.add(png));
    }
    
}
