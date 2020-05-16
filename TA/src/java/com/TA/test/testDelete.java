/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TA.test;

import com.TA.Dao.impl.userDaoImpl;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author teguh
 */
public class testDelete {
    
    public static void main(String[]args) throws SQLException{
    
        int id;  
     Scanner keyboard = new Scanner(System.in);
     System.out.print("id: ");
     id = Integer.parseInt(keyboard.nextLine());
     userDaoImpl delete = new userDaoImpl();
     
     int status = delete.delete(id) ;
     
     if(status == 1){
     System.out.println("Data berhasil dihapus");
     
     }else{
     
         System.out.println("Data gagal dihapus");
         
     }
     
     
        
        
    }
    
}
