/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TA.test.jenisbangunan;

import com.TA.Dao.impl.jenisBangunanDaoImpl;
import java.sql.SQLException;

/**
 *
 * @author teguh
 */
public class getAlljenisBangunan {
    
    public static void main(String []args) throws SQLException{
    
        
        jenisBangunanDaoImpl jen = new jenisBangunanDaoImpl();
        
        jen.getAll();
    }
    
}
