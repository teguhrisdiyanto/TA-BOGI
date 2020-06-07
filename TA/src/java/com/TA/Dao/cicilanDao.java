/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TA.Dao;

import com.TA.models.cicilan;
import java.util.List;

/**
 *
 * @author Tri Bogi B
 */
public interface cicilanDao<J> {
    public int insert(J object);
    public int update (J object);
    public int delete (int id);
    public cicilan getbyid(int id);
    public int autonumber(J object);  
    
    public List<J> getAll(String id);
}
