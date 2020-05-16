/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TA.Dao.impl;

import com.TA.Dao.pelangganDao;
import com.TA.Dao.userDao;
import com.TA.koneksiDb.koneksi;
import com.TA.models.pelanggan;
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
public class pelangganDaoImpl implements pelangganDao<pelanggan> {
    koneksi connect = new koneksi();
    Gson gson = new Gson();

    public pelangganDaoImpl() throws SQLException {
        connection = connect.bukakoneksidb();
        
    }
    Connection connection;

    @Override
    public int insert(pelanggan object) {
        PreparedStatement statement = null;
        int status = 0;
        String INSERT = "INSERT INTO _pelanggan (id_pelanggan,pelanggan_nama,pelanggan_alamat,pelanggan_nohp,pelanggan_email,pelanggan_pekerjaan) values(?,?,?,?,?,?)";
        try{
            statement = connection.prepareStatement(INSERT);
            statement.setInt(1, object.getId_pelanggan());
            statement.setString(2, object.getPelanggan_nama());
            statement.setString(3, object.getPelanggan_alamat());
            statement.setString(4, object.getPelanggan_nohp());
            statement.setString(5, object.getPelanggan_email());
            statement.setString(6, object.getPelanggan_pekerjaan());
            statement.executeUpdate();
            status = 1;
                
        
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch (SQLException ex){
            Logger.getLogger(userDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        return status;
    }

    @Override
    public int update(pelanggan object) {
          PreparedStatement statement = null;
        int Status = 0;
         String UPDATE = "UPDATE _pelanggan SET pelanggan_nama=?, pelanggan_alamat=?, pelanggan_nohp=?, pelanggan_email= ?, pelanggan_pekerjaan= ? WHERE id_pelanggan=?";
        try{
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, object.getPelanggan_nama());
            statement.setString(2, object.getPelanggan_alamat());
            statement.setString(3, object.getPelanggan_nohp());
            statement.setString(4, object.getPelanggan_email());
            statement.setString(5, object.getPelanggan_pekerjaan());
            statement.setInt(6, object.getId_pelanggan());
            statement.executeUpdate();
            Status = 1;
        }catch (Exception e){
            e.printStackTrace();
            Status = 0;
        }finally{
            try{
                statement.close();
            }catch (SQLException ex){
            Logger.getLogger(userDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        return Status;
    }

    @Override
    public int delete(int id) {
        PreparedStatement statement = null;
        String DELETE = "DELETE FROM _pelanggan WHERE id_pelanggan=?"; 
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
         Logger.getLogger(userDao.class.getName()).log(Level.SEVERE, null, ex);
         }
        }//To change body of generated methods, choose Tools | Templates.
        return Status;
    }

    @Override
    public pelanggan getbyid(int id) {
       PreparedStatement statement = null;
      
       String sqlid = "SELECT * FROM _pelanggan WHERE id_pelanggan = '" + id + "'";
        pelanggan pl = new pelanggan();
        try{
             
             statement = connection.prepareStatement(sqlid);
             
             ResultSet rs = statement.executeQuery();
             rs.next();
             pl.setId_pelanggan(rs.getInt("id_pelanggan"));
             pl.setPelanggan_nama(rs.getString("pelanggan_nama"));
             pl.setPelanggan_alamat(rs.getString("pelanggan_alamat"));
             pl.setPelanggan_nohp(rs.getString("pelanggan_nohp"));
             pl.setPelanggan_email(rs.getString("pelanggan_email"));
             pl.setPelanggan_pekerjaan(rs.getString("pelanggan_pekerjaan"));
             rs.close();
             System.out.println("Ini List Member Yang Ada DI DAO uSER :" + gson.toJson(pl));
             return pl;
        
        }catch(Exception e){
        System.out.println("Ini List Member Yang Ada DI DAO uSER CATCH :" + gson.toJson(pl));
        
            return pl;
        }
    }

    @Override
    public List<pelanggan> getAll() {
        List<pelanggan> list = null;
       PreparedStatement statement = null;
        String SELECT = "SELECT * FROM _pelanggan";
        try {
            list = new ArrayList<pelanggan>();
            statement = connection.prepareStatement(SELECT);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
            pelanggan P = new pelanggan();
            P.setId_pelanggan(rs.getInt("id_pelanggan"));
            P.setPelanggan_nama(rs.getString("pelanggan_nama"));
            P.setPelanggan_alamat(rs.getString("pelanggan_alamat"));
            P.setPelanggan_nohp(rs.getString("pelanggan_nohp"));
            P.setPelanggan_email(rs.getString("pelanggan_email"));
            P.setPelanggan_pekerjaan(rs.getString("pelanggan_pekerjaan"));

            list.add (P);
            
            }
        
        }catch(Exception e){
            e.printStackTrace();
        
        }
        System.out.println("Ini List Member Yang Ada DI DAO :" + gson.toJson(list));
        return list;
    }

    @Override
    public int autonumber(pelanggan object) {
         String Counter   = "SELECT max(id_pelanggan) as id_pelanggan FROM _pelanggan";
         PreparedStatement statement = null;
        int nomor = 0;
        try {
        statement = connection.prepareStatement(Counter);
        ResultSet rs = statement.executeQuery();
        if(rs.next())
            nomor = rs.getInt("id_pelanggan")+1;

        
        }catch(Exception e){
            e.printStackTrace();
        
        }
        return nomor;
    }
    
}
