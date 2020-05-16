/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TA.Dao.impl;

import com.TA.Dao.jenisBangunanDao;
import com.TA.koneksiDb.koneksi;
import com.TA.models.jenisBangunan;
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
public class jenisBangunanDaoImpl implements jenisBangunanDao<jenisBangunan> {
    koneksi connect = new koneksi();
    Gson gson = new Gson();

    public jenisBangunanDaoImpl() throws SQLException {
        connection = connect.bukakoneksidb();
    }
    
     Connection connection;
    @Override
    public int insert(jenisBangunan object) {
        PreparedStatement statement = null;
        int status = 0;
        String INSERT = "INSERT INTO _jenisbangun (id_jenisbangun,jenisbangun_nama) values(?,?)";
        try{
            statement = connection.prepareStatement(INSERT);
            statement.setInt(1, object.getId_jenisbangun());
            statement.setString(2, object.getJenisbangun_nama());
            statement.executeUpdate();
            status = 1;
                
        
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch (SQLException ex){
            Logger.getLogger(jenisBangunanDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        return status;
    }

    @Override
    public int update(jenisBangunan object) {
        PreparedStatement statement = null;
        int Status = 0;
         String UPDATE = "UPDATE _jenisbangun SET jenisbangun_nama=? WHERE id_jenisbangun=?";
        try{
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, object.getJenisbangun_nama());
            statement.setInt(2, object.getId_jenisbangun());
            statement.executeUpdate();
            Status = 1;
        }catch (Exception e){
            e.printStackTrace();
            Status = 0;
        }finally{
            try{
                statement.close();
            }catch (SQLException ex){
            Logger.getLogger(jenisBangunanDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        return Status;
    }

    @Override
    public int delete(int id) {
        PreparedStatement statement = null;
        String DELETE = "DELETE FROM _jenisbangun WHERE id_jenisbangun=?"; 
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
         Logger.getLogger(jenisBangunanDao.class.getName()).log(Level.SEVERE, null, ex);
         }
        }//To change body of generated methods, choose Tools | Templates.
        return Status;
    }

    @Override
    public jenisBangunan getbyid(int id) {
        PreparedStatement statement = null;
      
       String sqlid = "SELECT * FROM _jenisbangun WHERE id_jenisbangun = '" + id + "'";
        jenisBangunan lok = new jenisBangunan();
        try{
             
             statement = connection.prepareStatement(sqlid);
             
             ResultSet rs = statement.executeQuery();
             rs.next();
             lok.setId_jenisbangun(rs.getInt("id_jenisbangun"));
             lok.setJenisbangun_nama(rs.getString("jenisbangun_nama"));

             rs.close();
             System.out.println("Ini List Member Yang Ada DI DAO uSER :" + gson.toJson(lok));
             return lok;
        
        }catch(Exception e){
        System.out.println("Ini List Member Yang Ada DI DAO uSER CATCH :" + gson.toJson(lok));
        
            return lok;
        }
    }

    @Override
    public int autonumber(jenisBangunan object) {
        String Counter   = "SELECT max(id_jenisbangun) as id_jenisbangun FROM _jenisbangun";
         PreparedStatement statement = null;
        int nomor = 0;
        try {
        statement = connection.prepareStatement(Counter);
        ResultSet rs = statement.executeQuery();
        if(rs.next())
            nomor = rs.getInt("id_jenisbangun")+1;

        
        }catch(Exception e){
            e.printStackTrace();
        
        }
        return nomor;
    }

    @Override
    public List<jenisBangunan> getAll() {
       List<jenisBangunan> list = null;
       PreparedStatement statement = null;
        String SELECT = "SELECT * FROM _jenisbangun";
        try {
            list = new ArrayList<jenisBangunan>();
            statement = connection.prepareStatement(SELECT);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
            jenisBangunan jen = new jenisBangunan();
            jen.setId_jenisbangun(rs.getInt("id_jenisbangun"));
            jen.setJenisbangun_nama(rs.getString("jenisbangun_nama"));
           

            list.add (jen);
            
            }
        
        }catch(Exception e){
            e.printStackTrace();
        
        }
        System.out.println("Ini List Member Yang Ada DI DAO :" + gson.toJson(list));
        return list;
    }
    
    
}
