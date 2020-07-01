/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TA.Login;

import com.TA.Dao.impl.userDaoImpl;
import com.TA.models.users;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Tri Bogi B
 */
public class test_login {
    
    public static void main(String []args) throws SQLException{
     String User , pass, status;
     Scanner keyboard = new Scanner(System.in);
     System.out.print("Nama Users: ");
     User = keyboard.nextLine();
  
     users u = new users();
     u.setUserame(User);
     
        System.out.println("ini user : " + u.getUserame());
    
    }
    
}
