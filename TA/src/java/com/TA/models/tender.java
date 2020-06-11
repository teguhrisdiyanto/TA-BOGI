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
public class tender {
    private int id_tender;
    private int id_pelangaan;
    private int id_jenisbangun;
    private int id_lokasi;
    private pelanggan Pelanggan;
    private jenisBangunan Jenis_Bangunan;
    private lokasi Lokasi;
    private String tender_tanggaltender;
    private String tender_namatender;
    private String tender_nilaikontrak;
    private String tender_nilaidp ;
    private String sisabayar;

    public int getId_pelangaan() {
        return id_pelangaan;
    }

    public void setId_pelangaan(int id_pelangaan) {
        this.id_pelangaan = id_pelangaan;
    }

    public int getId_jenisbangun() {
        return id_jenisbangun;
    }

    public void setId_jenisbangun(int id_jenisbangun) {
        this.id_jenisbangun = id_jenisbangun;
    }

    public int getId_lokasi() {
        return id_lokasi;
    }

    public void setId_lokasi(int id_lokasi) {
        this.id_lokasi = id_lokasi;
    }

    public int getId_tender() {
        return id_tender;
    }

    public void setId_tender(int id_tender) {
        this.id_tender = id_tender;
    }

    public pelanggan getPelanggan() {
        return Pelanggan;
    }

    public void setPelanggan(pelanggan Pelanggan) {
        this.Pelanggan = Pelanggan;
    }

    public jenisBangunan getJenis_Bangunan() {
        return Jenis_Bangunan;
    }

    public void setJenis_Bangunan(jenisBangunan Jenis_Bangunan) {
        this.Jenis_Bangunan = Jenis_Bangunan;
    }

    public lokasi getLokasi() {
        return Lokasi;
    }

    public void setLokasi(lokasi Lokasi) {
        this.Lokasi = Lokasi;
    }

    public String getTender_tanggaltender() {
        return tender_tanggaltender;
    }

    public void setTender_tanggaltender(String tender_tanggaltender) {
        this.tender_tanggaltender = tender_tanggaltender;
    }

 

    public String getTender_namatender() {
        return tender_namatender;
    }

    public void setTender_namatender(String tender_namatender) {
        this.tender_namatender = tender_namatender;
    }

    public String getTender_nilaikontrak() {
        return tender_nilaikontrak;
    }

    public void setTender_nilaikontrak(String tender_nilaikontrak) {
        this.tender_nilaikontrak = tender_nilaikontrak;
    }

    public String getTender_nilaidp() {
        return tender_nilaidp;
    }

    public void setTender_nilaidp(String tender_nilaidp) {
        this.tender_nilaidp = tender_nilaidp;
    }

    public String getSisabayar() {
        return sisabayar;
    }

    public void setSisabayar(String sisabayar) {
        this.sisabayar = sisabayar;
    }


    
    
}
