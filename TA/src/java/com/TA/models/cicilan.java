/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TA.models;

/**
 *
 * @author Tri Bogi B
 */
public class cicilan {
    
    private int id_cicilan;
    private String cicilan_nominal;
    private tender Tender;
    private long cicilan_tgl ;

    public int getId_cicilan() {
        return id_cicilan;
    }

    public tender getTender() {
        return Tender;
    }

    public void setTender(tender Tender) {
        this.Tender = Tender;
    }

    public void setId_cicilan(int id_cicilan) {
        this.id_cicilan = id_cicilan;
    }

    public String getCicilan_nominal() {
        return cicilan_nominal;
    }

    public void setCicilan_nominal(String cicilan_nominal) {
        this.cicilan_nominal = cicilan_nominal;
    }

    public long getCicilan_tgl() {
        return cicilan_tgl;
    }

    public void setCicilan_tgl(long cicilan_tgl) {
        this.cicilan_tgl = cicilan_tgl;
    }
    
    
}
