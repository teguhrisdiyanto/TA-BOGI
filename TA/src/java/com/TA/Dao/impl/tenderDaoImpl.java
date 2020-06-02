/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TA.Dao.impl;

import com.TA.Dao.tenderDao;
import com.TA.koneksiDb.koneksi;
import com.TA.models.jenisBangunan;
import com.TA.models.lokasi;
import com.TA.models.pelanggan;
import com.TA.models.tender;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tri Bogi B
 */
public class tenderDaoImpl implements tenderDao<tender> {
    koneksi connect = new koneksi();
    Gson gson = new Gson();

  
      public tenderDaoImpl() throws SQLException {
        connection = connect.bukakoneksidb();
    }
    
     Connection connection;

  
     
    @Override
    public int insert(tender object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(tender object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public tender getbyid(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int autonumber(tender object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<tender> getAll() {
          List<tender> list = null;
       PreparedStatement statement = null;
       
        String SELECT = "select _tender.id_tender,_tender.tender_namatender,_pelanggan.pelanggan_nama, "
                + "_lokasi.lokasi_namalokasi, _jenisbangun.jenisbangun_nama, _tender.tender_tanggaltender "
                + "from _tender INNER JOIN _pelanggan ON _pelanggan.id_pelanggan = _tender.id_pelanggan INNER JOIN "
                + "_lokasi ON _tender._lokasi_id_lokasi = _lokasi.id_lokasi INNER JOIN _jenisbangun ON _jenisbangun.id_jenisbangun = _tender.id_jenisbangun";
       try {
            list = new ArrayList<tender>();
            statement = connection.prepareStatement(SELECT);
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
            tender T = new tender();
            T.setId_tender(rs.getInt("id_tender"));
            T.setTender_namatender(rs.getString("tender_namatender"));
            T.setTender_tanggaltender(rs.getLong("tender_tanggaltender"));
            
            pelanggan P = new pelanggan();
            P.setPelanggan_nama(rs.getString("pelanggan_nama"));
            T.setPelanggan(P);
            
            lokasi L = new lokasi();
            L.setLokasi_namalokasi(rs.getString("lokasi_namalokasi"));
            T.setLokasi(L);
            
            jenisBangunan J = new jenisBangunan();
            J.setJenisbangun_nama(rs.getString("jenisbangun_nama"));
            T.setJenis_Bangunan(J);
            list.add (T);
            
            }
        
        }catch(Exception e){
            e.printStackTrace();
        
        }
        return list;
    }
    
}
