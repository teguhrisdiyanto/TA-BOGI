/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TA.test;

import com.TA.Dao.impl.userDaoImpl;
import com.TA.models.users;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author teguh
 */
public class test {
    public static void main(String[]args) throws SQLException{
    userDaoImpl test = new userDaoImpl();
    String User , pass;
     Scanner keyboard = new Scanner(System.in);
     System.out.print("Nama Users: ");
     User = keyboard.nextLine();
     
     Scanner keyboard2 = new Scanner(System.in);
     System.out.print("Password: ");
     pass = keyboard2.nextLine();
            users usr = new users();
            usr = test.username(User);
            String username = usr.getUserame();
            
            if(User.equals(username)){
             username = usr.getUserame();
              String pwd = usr.getPassword();
                if(pass.equals(pwd)){
                     JOptionPane.showMessageDialog(null,"Selamat Anda Berhasil Login","pesan", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null," Anda Gagal Login","pesan", JOptionPane.INFORMATION_MESSAGE);

                }
    
                System.out.println("Ini User : " + username);
                System.out.println("Ini Password : " + pass);
            
            }else{
            
            JOptionPane.showMessageDialog(null,"Username Tidak ada","pesan", JOptionPane.INFORMATION_MESSAGE);
            }

    
    
    } 
    
}
