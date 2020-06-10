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
import java.util.logging.Level;
import java.util.logging.Logger;

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
         PreparedStatement statement = null;
        int status = 0;
        String INSERT = "insert into _tender (id_tender,id_pelanggan,id_jenisbangun,_lokasi_id_lokasi,"
                + "tender_tanggaltender,tender_namatender,tender_nilaikontrak,tender_nilaidp,sisabayar)"
                + " VALUES (?,?,?,?,?,?,?,?,?)";
        try{
            statement = connection.prepareStatement(INSERT);
            statement.setInt(1, object.getId_tender());
            statement.setInt(2, object.getId_pelangaan());
            statement.setInt(3, object.getId_jenisbangun());
            statement.setInt(4, object.getId_lokasi());
            statement.setString(5, object.getTender_tanggaltender());
            statement.setString(6, object.getTender_namatender());
            statement.setString(7, object.getTender_nilaikontrak());
            statement.setString(8, object.getTender_nilaidp());
            statement.setString(9, object.getSisabayar());
            statement.executeUpdate();
            status = 1;
                
        
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch (SQLException ex){
            Logger.getLogger(tenderDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        return status;
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
        PreparedStatement statement = null;
        String byid = " select _tender.id_tender,_tender.tender_namatender, "
                + "_pelanggan.pelanggan_nama,_pelanggan.pelanggan_nohp,_pelanggan.pelanggan_email,"
                + " _pelanggan.pelanggan_alamat,_pelanggan.pelanggan_pekerjaan, _lokasi.lokasi_namalokasi,"
                + " _jenisbangun.jenisbangun_nama, _tender.tender_nilaikontrak, _tender.tender_nilaidp,_tender.sisabayar,"
                + " _tender.tender_tanggaltender from _tender INNER JOIN _pelanggan ON _pelanggan.id_pelanggan = _tender.id_pelanggan"
                + " INNER JOIN _lokasi ON _tender._lokasi_id_lokasi = _lokasi.id_lokasi INNER JOIN _jenisbangun ON _jenisbangun.id_jenisbangun "
                + "= _tender.id_jenisbangun WHERE id_tender = '"+ id +"'";
               // "SELECT *  FROM _tender T, _pelanggan P, _jenisbangun J, _lokasi L where id_tender = '" + id + "'";
       tender tn = new tender();
        try{
             
             statement = connection.prepareStatement(byid);
             
             ResultSet rs = statement.executeQuery();
             rs.next();
             tn.setId_tender(rs.getInt("id_tender"));
//             tn.setId_pelangaan(rs.getInt("id_pelanggan"));
//             tn.setId_jenisbangun(rs.getInt("id_jenisbangun"));
//             tn.setId_lokasi(rs.getInt("_lokasi_id_lokasi"));
             tn.setTender_namatender(rs.getString("tender_namatender"));
             
             
             pelanggan pl = new pelanggan();
//             pl.setId_pelanggan(rs.getInt("id_pelanggan"));
             pl.setPelanggan_nama(rs.getString("pelanggan_nama"));
             pl.setPelanggan_nohp(rs.getString("pelanggan_nohp"));
             pl.setPelanggan_email(rs.getString("pelanggan_email"));
             pl.setPelanggan_alamat(rs.getString("pelanggan_alamat"));
             pl.setPelanggan_pekerjaan(rs.getString("pelanggan_pekerjaan"));
             tn.setPelanggan(pl);
             
             
            lokasi L = new lokasi();
//            L.setId_lokasi(rs.getInt("lokasi_id_lokasi"));
            L.setLokasi_namalokasi(rs.getString("lokasi_namalokasi"));
            tn.setLokasi(L);
             
            jenisBangunan J = new jenisBangunan();
//            J.setId_jenisbangun(rs.getInt("id_jenisbangun"));
            J.setJenisbangun_nama(rs.getString("jenisbangun_nama"));
            tn.setJenis_Bangunan(J);
            
            tn.setTender_nilaikontrak(rs.getString("tender_nilaikontrak"));
            tn.setTender_nilaidp(rs.getString("tender_nilaidp"));
            tn.setSisabayar(rs.getString("sisabayar"));
            tn.setTender_tanggaltender(rs.getString("tender_tanggaltender"));
            
            
           
             
             
             rs.close();
             System.out.println("Ini List Member Yang Ada DI DAO uSER :" + gson.toJson(tn));
             return tn;
        
        }catch(Exception e){
        System.out.println("Ini List Member Yang Ada DI DAO uSER CATCH :" + gson.toJson(tn));
        
            return tn;
        }
        
        
    }

    @Override
    public int autonumber(tender object) {
     String Counter   = "SELECT max(id_tender) as id_tender FROM _tender";
         PreparedStatement statement = null;
        int nomor = 0;
        try {
        statement = connection.prepareStatement(Counter);
        ResultSet rs = statement.executeQuery();
        if(rs.next())
            nomor = rs.getInt("id_tender")+1;

        
        }catch(Exception e){
            e.printStackTrace();
        
        }
       return nomor;
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
            T.setTender_tanggaltender(rs.getString("tender_tanggaltender"));
            
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
