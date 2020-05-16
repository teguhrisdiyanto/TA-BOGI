/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TA.test;

import com.TA.Dao.impl.userDaoImpl;
import com.TA.models.users;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author teguh
 */
public class testUpdate {
    
    public static void main(String[]args) throws SQLException{
     userDaoImpl insert = new userDaoImpl();
    users u = new users();
    int a = insert.autonumber(u);
    String User , pass, status;
    int id;  
     Scanner keyboard = new Scanner(System.in);
     System.out.print("id: ");
     id = Integer.parseInt(keyboard.nextLine());
     
     Scanner keyboard5 = new Scanner(System.in);
     System.out.print("Nama Users: ");
     User = keyboard.nextLine();
     
     Scanner keyboard2 = new Scanner(System.in);
     System.out.print("Password: ");
     pass = keyboard2.nextLine();
     
     Scanner keyboard3 = new Scanner(System.in);
     System.out.print("user status: ");
     status = keyboard2.nextLine();
     u.setId_user(id);
     u.setUserame(User);
     u.setPassword(pass);
     u.setUser_status(status);
     
     int i =  insert.update(u);
    if (i == 0){
        System.out.println("data gagal di update");
    
    }else{
    
        System.out.println("data berhasil di update" );
    
    }
    
    }
    
}
