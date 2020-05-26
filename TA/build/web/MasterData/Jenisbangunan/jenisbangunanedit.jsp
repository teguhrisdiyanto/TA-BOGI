<%-- 
    Document   : jenisbangunanedit
    Created on : May 21, 2020, 2:31:48 PM
    Author     : teguh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<section class="content-header">
      
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
              <h3 class="box-title">Edit Data Jenis Bangunan</h3>

             
             </div>
              
                     
                  
              
              
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
              <form class="form-horizontal" id="form1" name="form1" method="post" action="jenisBangunan?go=jenisbangunan_editsave">
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
                   <input type="hidden" value="${id}" name="jenbangunid"/>
                  <div class="input-group input-group-sm">
                  <div class="col-sm-10">
                     <span class="input-group-btn">
                         <input class="form-control" name="Jenisbangunan"  id="kode" type="text"  size="50" maxlength="25" placeholder="Nama"  value="${jenisbangunan}" required />
                     
                    </span>
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
