/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TA.Dao;

import com.TA.models.pelanggan;
import java.util.List;

/**
 *
 * @author teguh
 */
public interface pelangganDao<P> {
    
    public int insert(P object);
    public int update (P object);
    public int delete (int id);
    public pelanggan getbyid(int id);
    public int autonumber(P object);
    
    
    public List<P> getAll();
     
    
}
