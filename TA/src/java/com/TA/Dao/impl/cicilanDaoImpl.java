/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TA.Dao.impl;

import com.TA.Dao.cicilanDao;
import com.TA.koneksiDb.koneksi;
import com.TA.models.cicilan;
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
 * @author teguh
 */
public class cicilanDaoImpl implements cicilanDao<cicilan> {
    koneksi connect = new koneksi();
    Gson gson = new Gson();

    public cicilanDaoImpl() throws SQLException {
        this.connection = connect.bukakoneksidb();
    }

     Connection connection;
    @Override
    public int insert(cicilan object) {
         PreparedStatement statement = null;
         
         System.out.println("ini obj cicilan id tender :" + object.getId_tender());
         System.out.println("ini obj cicilan id pelanggan :" + object.getId_pelanggan());
         System.out.println("ini obj cicilan id jenis bangun :" + object.getId_jenisbangunan());
         System.out.println("ini obj cicilan id lokasi : " + object.getId_lokasi());
        int status = 0;
        String insert = "insert into _cicilan (id_cicilan, cicilan_tgl, cicilan_nominal,"
                + " _tender_id_tender,_tender_id_pelanggan,_tender_id_jenisbangun,_tender__lokasi_id_lokasi)"
                + " VALUES (?,?,?,?,?,?,?)";
        try{
            statement = connection.prepareStatement(insert);
            statement.setInt(1, object.getId_cicilan());
            statement.setString(2, object.getCicilan_tgl());
            statement.setString(3, object.getCicilan_nominal());
            statement.setInt(4, object.getId_tender());
            statement.setInt(5, object.getId_pelanggan());
            statement.setInt(6, object.getId_jenisbangunan());
            statement.setInt(7, object.getId_lokasi());
            statement.executeUpdate();
            status = 1;
                
        
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch (SQLException ex){
            Logger.getLogger(cicilanDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        return status;
    
    }
    

    @Override
    public int update(cicilan object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        PreparedStatement statement = null;
        String DELETE = "DELETE FROM _cicilan WHERE id_cicilan=?"; 
        int Status = 0 ;
        try{
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1, id);
            statement.executeUpdate();
            Status = 1;
        }catch(Exception e){
          Status = 0;
        }finally{
         try{
         statement.close();
         }catch (SQLException ex){
         Logger.getLogger(cicilanDao.class.getName()).log(Level.SEVERE, null, ex);
         }
        }//To change body of generated methods, choose Tools | Templates.
        return Status;
    }

    @Override
    public cicilan getbyid(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int autonumber(cicilan object) {
       String Counter   = "SELECT max(id_cicilan) as id_cicilan FROM _cicilan";
         PreparedStatement statement = null;
        int nomor = 0;
        try {
        statement = connection.prepareStatement(Counter);
        ResultSet rs = statement.executeQuery();
        if(rs.next())
            nomor = rs.getInt("id_cicilan")+1;

        
        }catch(Exception e){
            e.printStackTrace();
        
        }
        return nomor;
    
    }

    @Override
    public List<cicilan> getAll(int id) {
        List<cicilan> list = null;
       PreparedStatement statement = null;
        String SELECT = "SELECT * FROM _cicilan where _tender_id_tender = '" + id + "'";
        try {
            list = new ArrayList<cicilan>();
            statement = connection.prepareStatement(SELECT);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
            cicilan  cil = new cicilan();
            cil.setId_cicilan(rs.getInt("id_cicilan"));
            cil.setCicilan_tgl(rs.getString("cicilan_tgl"));
            cil.setCicilan_nominal(rs.getString("cicilan_nominal"));
            cil.setId_tender(rs.getInt("_tender_id_tender"));
            list.add (cil);
            
            }
        
        }catch(Exception e){
            e.printStackTrace();
        
        }
        System.out.println("Ini List Member Yang Ada DI DAO :" + gson.toJson(list));
        return list;
    }
    
}
