/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TA.Dao;

import com.TA.models.tender;
import java.util.List;

/**
 *
 * @author Tri Bogi B
 */
public interface tenderDao <TD> {
    public int insert(TD object);
    public int update (TD object);
    public int delete (int id);
    public tender getbyid(int id);
    public int autonumber(TD object);  
    
    public List<TD> getAll();
}
