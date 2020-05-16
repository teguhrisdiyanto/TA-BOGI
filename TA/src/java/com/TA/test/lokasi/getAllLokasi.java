/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TA.test.lokasi;

import com.TA.Dao.impl.lokasiDaoImpl;
import java.sql.SQLException;

/**
 *
 * @author teguh
 */
public class getAllLokasi {
    
    public static void main(String []args) throws SQLException{
    
        
        lokasiDaoImpl lok = new lokasiDaoImpl();
        
        lok.getAll();
    }
    
}
