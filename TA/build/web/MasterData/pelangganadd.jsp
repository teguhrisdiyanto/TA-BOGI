<%-- 
    Document   : pelangganadd
    Created on : Jan 1, 2028, 9:53:12 AM
    Author     : teguh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<section class="content-header">
      
      <h1>
        Simple Tables
        <small>preview of simple tables</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Tables</a></li>
        <li class="active">Simple</li>
      </ol>
    </section>

    <section class="content">
      <!-- /.row -->
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">Tambah Data Pelanggan</h3>

             
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
                  <label for="inputEmail3" class="col-sm-4 control-label">Nama</label>
                  
                  <div class="input-group input-group-sm">
                  <div class="col-sm-10">
                     <span class="input-group-btn">
                         <input class="form-control" name="namapelanggan"  id="kode" type="text"  size="50" maxlength="25" placeholder="Nama"  value="${namaKaryawan}" required />
                     
                    </span>
                  </div>
                  </div>
                 
                </div>
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-4 control-label">Alamat</label>
                    
                  <div class="input-group input-group-sm">
                  <div class="col-sm-12">
                      
                      <textarea class="form-control" name="alamatpelanggan" rows="5" cols="42"  placeholder="Alamat" required >${alamatKaryawan}</textarea>
                      <!--<textarea type="text" class="form-control" name="alamatKaryawan" row="50" cols="50" value="${alamatKaryawan}" placeholder="Alamat" required></textarea>-->
                  </div>
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-4 control-label">No Hp</label>
                    
                  <div class="input-group input-group-sm">
                  <div class="col-sm-12">
                     <input type="text" class="form-control"  name="nohp"  id="datemask" size="40" maxlength="35" value="${tanggalLahir}" placeholder="no Hp" required/>
                  </div>
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-4 control-label">Email</label>
                    
                  <div class="input-group input-group-sm">
                  <div class="col-sm-12">
                    <input type="email" class="form-control" name="emailpelanggan"  id="phone" size="40" maxlength="20" value="${emailKaryawan}" placeholder="Ex : bogibobogi@gmail.com" required />
                  </div>
                  </div>
                </div>
                  
                  
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-4 control-label">Pekerjaan</label>
                    
                  <div class="input-group input-group-sm">
                  <div class="col-sm-12">
                    <input type="text" class="form-control" name="pekerjaan"  id="nmkategoritxt" size="40" maxlength="15" value="${noTlp}" placeholder="pekerjaan" required  onkeypress="return onlyNumberKey(event)"/>
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