/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TA.test;

import com.TA.enkripsi.AES;

/**
 *
 * @author Tri Bogi B
 */
public class enkriptest {
    
    
    
    public static void main(String [] args){
    String a = "test";
        System.out.println(AES.encrypt(a));
    
    }
   
}
