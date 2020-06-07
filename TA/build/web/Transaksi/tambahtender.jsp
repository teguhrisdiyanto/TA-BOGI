<%-- 
    Document   : tambahtender
    Created on : Jun 6, 2020, 11:52:22 PM
    Author     : Tri Bogi B
--%>

<%@page import="com.TA.models.lokasi"%>
<%@page import="com.TA.models.jenisBangunan"%>
<%@page import="com.TA.models.pelanggan"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<section class="content-header">
   
      <% ArrayList listpel = (ArrayList)request.getAttribute("listpel"); %>
      <% ArrayList listjen = (ArrayList)request.getAttribute("listjen"); %>
      <% ArrayList listlok = (ArrayList)request.getAttribute("listlok"); %>
      <h1>
        CV Pandu Putra Sarana
      </h1>
    </section>

    <section class="content">
      <!-- /.row -->
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">Tambah Data Tender</h3>

             
             </div>

            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
              <form class="form-horizontal" id="form1" name="form1" method="post" action="Pelanggan?go=pelanggan_save">
              <div class="box-body">
               <div class="alert alert-success alert-dismissible se-pre-conberhasil">
                       
                          <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                          <h4><i class="icon fa fa-check"></i> Selamat !</h4>
                         Data Telah berhasil Di Input
                         
                        </div>
                  
                   <div class="alert alert-danger alert-dismissible se-pre-congagal">
                          <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                          <h4><i class="icon fa fa-check"></i> Peringatan !</h4>
                          DATA GAGAL DI INPUT
                        </div>
                  
                  
                  
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-4 control-label">Nama Tender</label>
                  
                  <div class="input-group input-group-sm">
                  <div class="col-sm-10">
                     <span class="input-group-btn">
                         <input class="form-control" name="namapelanggan"  id="kode" type="text"  size="50" maxlength="150" placeholder="Nama"  value="${namaKaryawan}" required />
                     
                    </span>
                  </div>
                  </div>
                 
                </div>
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-4 control-label">Nama Pelanggan</label>
                    
                  <div class="input-group input-group-sm">
                  <div class="col-sm-12">
                      
                        <select class="form-control select2 select2-hidden-accessible" style="width: 100%;" tabindex="-1" aria-hidden="true">
                            
                 <%     
                     List<pelanggan> list;
                     list = listpel;
                     for (pelanggan pl : list) {
                                
                              int  id_pelanggan = pl.getId_pelanggan();
                              String  pelanggan_nama = pl.getPelanggan_nama(); 

                               
                                

                    %>
                    
                    <option value="<%=id_pelanggan %>"><%= pelanggan_nama%></option>
                                    
                            <%
                            }
                    %>
                        </select>
                  </div>
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-4 control-label">No Jenis Bangunan</label>
                    
                  <div class="input-group input-group-sm">
                  <div class="col-sm-12">
                                            <select class="form-control select2 select2-hidden-accessible" style="width: 100%;" tabindex="-1" aria-hidden="true">
                            
                 <%     
                     List<jenisBangunan> list2;
                     list2 = listjen;
                     for (jenisBangunan je : list2) {
                                
                              int  id_jenis = je.getId_jenisbangun();
                              String  jenisbangun = je.getJenisbangun_nama(); 

                    %>
                    
                    <option value="<%=id_jenis %>"><%= jenisbangun%></option>
                                    
                            <%
                            }
                    %>
                        </select>
                      
                      
                  </div>
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-4 control-label">Email</label>
                    
                  <div class="input-group input-group-sm">
                  <div class="col-sm-12">
                   <select class="form-control select2 select2-hidden-accessible" style="width: 100%;" tabindex="-1" aria-hidden="true">
                            
                 <%     
                     List<lokasi> list3;
                     list3 = listlok;
                     for (lokasi lok : list3) {
                                
                              int  id_lokasi = lok.getId_lokasi();
                              String  loakasi = lok.getLokasi_namalokasi(); 

                    %>
                    
                    <option value="<%=id_lokasi %>"><%= loakasi%></option>
                                    
                            <%
                            }
                    %>
                        </select>
                  </div>
                  </div>
                </div>
                  
                  
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-4 control-label">Nilai Kontrak</label>
                    
                  <div class="input-group input-group-sm">
                  <div class="col-sm-12">
                    <input type="text" class="form-control" name="hargaObat" id ="hargaObat" size="40" maxlength="100" value="${noTlp}" placeholder="Pekerjaan" required  onkeypress="return onlyNumberKey(event)"/>
                  </div>
                  </div>
                </div>
                  
                   <div class="form-group">
                  <label for="inputPassword3" class="col-sm-4 control-label">Nilai DP</label>
                    
                  <div class="input-group input-group-sm">
                  <div class="col-sm-12">
                    <input type="text" class="form-control" name="hargaKonsul" id ="hargaKonsul" size="40" maxlength="100" value="${noTlp}" placeholder="Pekerjaan" required  onkeypress="return onlyNumberKey(event)"/>
                  </div>
                  </div>
                </div>
                  
                  
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-4 control-label">Sisa Bayar</label>
                    
                  <div class="input-group input-group-sm">
                  <div class="col-sm-12">
                    <input type="text" class="form-control" name="totalBayar" id ="totalBayar" size="40" maxlength="100" value="${noTlp}" placeholder="Pekerjaan" required  onkeypress="return onlyNumberKey(event)"/>
                  </div>
                  </div>
                </div>
     
     
              
               
              </div>
              <!-- /.box-body -->
              <div class="box-footer">           
                  <button name="simpan" value="Simpan" id="simpankaryawan" class="btn btn-info ">Simpan</button>&nbsp
                <button type="reset" name="reset" value="Reset" class="btn btn-primary">Reset</button>&nbsp
              </div>
              <!-- /.box-footer -->
            </form>
                  
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
      </div>
    </section>