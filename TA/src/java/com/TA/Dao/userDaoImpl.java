/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TA.Dao;

import com.TA.koneksiDb.koneksi;
import com.TA.models.users;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

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
    public void insert(users object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(users object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int autonumber(users object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            U.setUserame(rs.getString("username"));
            U.setPassword(rs.getString("password"));

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
      
       String CARI = "SELECT * FROM _user WHERE username = '" + username + "'";
        
        try{
             
             statement = connection.prepareStatement(CARI);
             
             ResultSet rs = statement.executeQuery();
             rs.next();
             usr.setUserame(rs.getString("username"));
             usr.setPassword(rs.getString("password"));
             rs.close();
             System.out.println("Ini List Member Yang Ada DI DAO uSER :" + gson.toJson(usr));
             return usr;
        
        }catch(Exception e){
        System.out.println("Ini List Member Yang Ada DI DAO uSERCATCH :" + gson.toJson(usr));
        
            return usr;
        }
      
       
      
    }






}
