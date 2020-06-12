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
public class insert_tender {
    
    
    public static void main(String []args) throws SQLException{
    
         String tender_tanggaltender, tender_namatender, tender_nilaikontrak, tender_nilaidp ,sisabayar;
         int id_tender,id_pelangaan,id_jenisbangun,id_lokasi;
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

         Scanner keyboard3 = new Scanner(System.in);
         System.out.print("nilai kontrak: ");
         tender_nilaikontrak = keyboard2.nextLine();
         
         Scanner keyboard4 = new Scanner(System.in);
         System.out.print("nilai DP  ");
         tender_nilaidp = keyboard2.nextLine();
         
         int id1  = Integer.parseInt(tender_nilaikontrak);
         int id2  = Integer.parseInt(tender_nilaidp);
         sisabayar = Integer.toString(id1 - id2)  ;
         
        System.out.println("Sisa Bayar : " + sisabayar );
        
        
        tender tn = new tender();
        tenderDaoImpl mtender = new tenderDaoImpl();
        id_tender = mtender.autonumber(tn);
        
        tn.setId_tender(id_tender);
        tn.setId_pelangaan(id_pelangaan);
        tn.setId_jenisbangun(id_jenisbangun);
        tn.setId_lokasi(id_lokasi);
        tn.setTender_tanggaltender(AES.encrypt(tender_tanggaltender));
        tn.setTender_namatender(AES.encrypt(tender_namatender));
        tn.setTender_nilaikontrak(AES.encrypt(tender_nilaikontrak));
        tn.setTender_nilaidp(AES.encrypt(tender_nilaidp));
        tn.setSisabayar(AES.encrypt(sisabayar));
        
        int status = mtender.insert(tn);
        
        if (status == 1){
            System.out.println("data berhasil di input");
        
        }else{
            System.out.println("data gagal di input");
        }
    }
    
}
