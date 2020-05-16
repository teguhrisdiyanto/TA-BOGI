/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TA.Dao;

import com.TA.models.lokasi;
import java.util.List;

/**
 *
 * @author teguh
 */
public interface lokasiDao <D> {
    
    public int insert(D object);
    public int update (D object);
    public int delete (int id);
    public lokasi getbyid(int id);
    public int autonumber(D object);  
    
    public List<D> getAll();
     
}
