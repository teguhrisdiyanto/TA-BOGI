/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TA.Dao.impl;

import com.TA.Dao.lokasiDao;
import com.TA.koneksiDb.koneksi;
import com.TA.models.lokasi;
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
public class lokasiDaoImpl implements lokasiDao<lokasi> {
    koneksi connect = new koneksi();
    Gson gson = new Gson();

 
    
    
    Connection connection;

    public lokasiDaoImpl() throws SQLException {
        connection = connect.bukakoneksidb();
    }



    @Override
    public int insert(lokasi object) {
        PreparedStatement statement = null;
        int status = 0;
        String INSERT = "INSERT INTO _lokasi (id_lokasi,lokasi_namalokasi) values(?,?)";
        try{
            statement = connection.prepareStatement(INSERT);
            statement.setInt(1, object.getId_lokasi());
            statement.setString(2, object.getLokasi_namalokasi());
            statement.executeUpdate();
            status = 1;
                
        
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch (SQLException ex){
            Logger.getLogger(lokasiDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        return status;
    }

    @Override
    public int update(lokasi object) {
        PreparedStatement statement = null;
        int Status = 0;
         String UPDATE = "UPDATE _lokasi SET lokasi_namalokasi=? WHERE id_lokasi=?";
        try{
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, object.getLokasi_namalokasi());
            statement.setInt(2, object.getId_lokasi());
            statement.executeUpdate();
            Status = 1;
        }catch (Exception e){
            e.printStackTrace();
            Status = 0;
        }finally{
            try{
                statement.close();
            }catch (SQLException ex){
            Logger.getLogger(lokasiDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        return Status;
    }

    @Override
    public int delete(int id) {
        PreparedStatement statement = null;
        String DELETE = "DELETE FROM _lokasi WHERE id_lokasi=?"; 
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
         Logger.getLogger(lokasiDao.class.getName()).log(Level.SEVERE, null, ex);
         }
        }//To change body of generated methods, choose Tools | Templates.
        return Status;
    }

    @Override
    public lokasi getbyid(int id) {
        PreparedStatement statement = null;
      
       String sqlid = "SELECT * FROM _lokasi WHERE id_lokasi = '" + id + "'";
        lokasi lok = new lokasi();
        try{
             
             statement = connection.prepareStatement(sqlid);
             
             ResultSet rs = statement.executeQuery();
             rs.next();
             lok.setId_lokasi(rs.getInt("id_lokasi"));
             lok.setLokasi_namalokasi(rs.getString("lokasi_namalokasi"));

             rs.close();
             System.out.println("Ini List Member Yang Ada DI DAO uSER :" + gson.toJson(lok));
             return lok;
        
        }catch(Exception e){
        System.out.println("Ini List Member Yang Ada DI DAO uSER CATCH :" + gson.toJson(lok));
        
            return lok;
        }
    }

    @Override
    public int autonumber(lokasi object) {
        String Counter   = "SELECT max(id_lokasi) as id_lokasi FROM _lokasi";
         PreparedStatement statement = null;
        int nomor = 0;
        try {
        statement = connection.prepareStatement(Counter);
        ResultSet rs = statement.executeQuery();
        if(rs.next())
            nomor = rs.getInt("id_lokasi")+1;

        
        }catch(Exception e){
            e.printStackTrace();
        
        }
        return nomor;
    }

    @Override
    public List<lokasi> getAll() {
        List<lokasi> list = null;
       PreparedStatement statement = null;
        String SELECT = "SELECT * FROM _lokasi";
        try {
            list = new ArrayList<lokasi>();
            statement = connection.prepareStatement(SELECT);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
            lokasi L = new lokasi();
            L.setId_lokasi(rs.getInt("id_lokasi"));
            L.setLokasi_namalokasi(rs.getString("lokasi_namalokasi"));
           

            list.add (L);
            
            }
        
        }catch(Exception e){
            e.printStackTrace();
        
        }
        System.out.println("Ini List Member Yang Ada DI DAO :" + gson.toJson(list));
        return list;
    }
    
}
