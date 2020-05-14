/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TA.koneksiDb;


import java.sql.*;


/**
 *
 * @author teguh
 */
public class koneksi {
    public Connection bukakoneksidb()throws SQLException{
        Connection connect;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/ta_bogi","root","");
            return connect;
        }
        catch(Exception exc){

        }
        return null;
    }
    
}
