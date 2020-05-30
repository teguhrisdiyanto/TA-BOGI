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
    private  int id_tender;
    private pelanggan Pelanggan;
    private jenisBangunan Jenis_Bangunan;
    private lokasi Lokasi;
    private cicilan Cicilan;
    private long tender_tanggaltender;
    private String tender_namatender;
    private String tender_nilaikontrak;
    private String tender_nilaidp ;
    private String tender_alamat;

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

    public cicilan getCicilan() {
        return Cicilan;
    }

    public void setCicilan(cicilan Cicilan) {
        this.Cicilan = Cicilan;
    }

    public long getTender_tanggaltender() {
        return tender_tanggaltender;
    }

    public void setTender_tanggaltender(long tender_tanggaltender) {
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

    public String getTender_alamat() {
        return tender_alamat;
    }

    public void setTender_alamat(String tender_alamat) {
        this.tender_alamat = tender_alamat;
    }
    
    
}
