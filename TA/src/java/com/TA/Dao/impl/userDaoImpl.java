/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TA.Dao.impl;

import com.TA.Dao.userDao;
import com.TA.koneksiDb.koneksi;
import com.TA.models.users;
import com.google.gson.Gson;
import java.sql.Connection;
import java.util.*;
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
public class userDaoImpl implements userDao<users> {
Gson gson = new Gson();
 koneksi connect = new koneksi();
    public userDaoImpl() throws SQLException {
       
         connection = connect.bukakoneksidb();
    }
    Connection connection;
    
    
    @Override
    public int insert(users object,String username) {
         PreparedStatement statement = null;
         int status = 0;
        try{
             String CARI = "SELECT * FROM _user WHERE user_username = '" + username + "'";
            String INSERT = "INSERT INTO _user (id_user,user_username,user_password,user_status) values(?,?,?,?)";
            statement = connection.prepareStatement(CARI);
             
             ResultSet rs = statement.executeQuery();
             rs.next();
             
            if(rs.next()){
            status = 0;
            rs.close();
            }
              
            else{
            Date today = new Date();
            PreparedStatement statement2 = null;
            statement2 = connection.prepareStatement(INSERT);
            statement2.setInt(1, object.getId_user());
            statement2.setString(2, object.getUserame());
            statement2.setString(3, object.getPassword());
            statement2.setString(4, object.getUser_status());
            statement2.executeUpdate();
            status = 1;
                
      }   
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
    public int update(users object) {
        PreparedStatement statement = null;
        int Status = 0;
         String UPDATE = "UPDATE _user SET user_username=?, user_password=?, user_status=? WHERE id_user=?";
        try{
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, object.getUserame());
            statement.setString(2, object.getPassword());
            statement.setString(3, object.getUser_status());
            statement.setInt(4, object.getId_user());
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
        String DELETE = "DELETE FROM _user WHERE id_user=?"; 
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
    public int autonumber(users object) {
         String Counter   = "SELECT max(id_user) as id_user FROM _user";
         PreparedStatement statement = null;
        int nomor = 0;
        try {
        statement = connection.prepareStatement(Counter);
        ResultSet rs = statement.executeQuery();
        if(rs.next())
            nomor = rs.getInt("id_user")+1;

        
        }catch(Exception e){
            e.printStackTrace();
        
        }
        return nomor;
    }

    @Override
    public List<users> getAll() {
        List<users> list = null;
       PreparedStatement statement = null;
        String SELECT = "SELECT * FROM _user";
        try {
            list = new ArrayList<users>();
            statement = connection.prepareStatement(SELECT);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
            users U = new users();
            U.setUserame(rs.getString("user_username"));
            U.setPassword(rs.getString("user_password"));

            list.add (U);
            
            }
        
        }catch(Exception e){
            e.printStackTrace();
        
        }
        System.out.println("Ini List Member Yang Ada DI DAO :" + gson.toJson(list));
        return list;
    }

    @Override
    public List<users> Isicombo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<users> Isicombo1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<users> getCari(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public users username(String username) {
       users usr = new users();
        PreparedStatement statement = null;
      
       String CARI = "SELECT * FROM _user WHERE user_username = '" + username + "'";
        
        try{
             
             statement = connection.prepareStatement(CARI);
             
             ResultSet rs = statement.executeQuery();
             rs.next();
             usr.setId_user(rs.getInt("id_user"));
             usr.setUserame(rs.getString("user_username"));
             usr.setPassword(rs.getString("user_password"));
             rs.close();
             System.out.println("Ini List Member Yang Ada DI DAO uSER :" + gson.toJson(usr));
             return usr;
        
        }catch(Exception e){
        System.out.println("Ini List Member Yang Ada DI DAO uSERCATCH :" + gson.toJson(usr));
        
            return usr;
        }
      
       
      
    }






}
