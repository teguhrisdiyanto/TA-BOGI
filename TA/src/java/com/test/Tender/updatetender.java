/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.Tender;

import com.TA.Dao.impl.tenderDaoImpl;
import com.TA.enkripsi.AES;
import com.TA.models.tender;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author teguh
 */
public class updatetender {
    public static void main(String []args) throws SQLException{
    
        
         String tender_tanggaltender, tender_namatender, tender_nilaikontrak, tender_nilaidp ,sisabayar;
         int id_tender,id_pelangaan,id_jenisbangun,id_lokasi;
         
         Scanner keyboard11 = new Scanner(System.in);
         System.out.print("id tender yang ingin di update: ");
         id_tender = keyboard11.nextInt();
         
         Scanner keyboard = new Scanner(System.in);
         System.out.print("Nama Tender : "); 
         tender_namatender = keyboard.nextLine();
         
         Scanner keyboard6 = new Scanner(System.in);
         System.out.print("id_pelanggan : "); 
         id_pelangaan = keyboard6.nextInt();
         
         Scanner keyboard7 = new Scanner(System.in);
         System.out.print("id_jenisbangunan : "); 
         id_jenisbangun = keyboard7.nextInt();
         
         Scanner keyboard8 = new Scanner(System.in);
         System.out.print("id_lokasi : "); 
         id_lokasi =  keyboard8.nextInt();

         Scanner keyboard2 = new Scanner(System.in);
         System.out.print("tanggal tender: ");
         tender_tanggaltender = keyboard2.nextLine();
         
        tender tn = new tender();
        tenderDaoImpl mtender = new tenderDaoImpl();

        
        tn.setId_tender(id_tender);
        tn.setId_pelangaan(id_pelangaan);
        tn.setId_jenisbangun(id_jenisbangun);
        tn.setId_lokasi(id_lokasi);
        tn.setTender_tanggaltender(AES.encrypt(tender_tanggaltender));
        tn.setTender_namatender(AES.encrypt(tender_namatender));
    
        
        int status = mtender.update(tn);
        
        if (status == 1){
            System.out.println("data berhasil di input");
        
        }else{
            System.out.println("data gagal di input");
        }
    
    }
    
}
