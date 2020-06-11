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
    private int id_tender;
    private int id_pelanggan;
    private int id_jenisbangunan;
    private int id_lokasi;

    public int getId_pelanggan() {
        return id_pelanggan;
    }

    public void setId_pelanggan(int id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }

    public int getId_jenisbangunan() {
        return id_jenisbangunan;
    }

    public void setId_jenisbangunan(int id_jenisbangunan) {
        this.id_jenisbangunan = id_jenisbangunan;
    }

    public int getId_lokasi() {
        return id_lokasi;
    }

    public void setId_lokasi(int id_lokasi) {
        this.id_lokasi = id_lokasi;
    }
    

    private String cicilan_nominal;
    private tender Tender;
    private String cicilan_tgl ;

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

    public String getCicilan_tgl() {
        return cicilan_tgl;
    }

    public void setCicilan_tgl(String cicilan_tgl) {
        this.cicilan_tgl = cicilan_tgl;
    }

    public int getId_tender() {
        return id_tender;
    }

    public void setId_tender(int id_tender) {
        this.id_tender = id_tender;
    }


    
    
}
