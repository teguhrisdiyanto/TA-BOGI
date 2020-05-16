/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TA.Dao;

import com.TA.models.users;
import java.util.List;

/**
 *
 * @author teguh
 */
public interface userDao<A> {
    
public int insert (A object, String username);
public int update (A object);
public int delete (int id);
public users username (String username);
public int autonumber(A object);


public List<A> getAll();
public List<A> Isicombo();
public List<A> Isicombo1();
public List<A> getCari (String key);
    
}
