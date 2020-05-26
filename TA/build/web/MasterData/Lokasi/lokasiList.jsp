<%-- 
    Document   : lokasiList
    Created on : Jan 1, 2028, 9:10:54 AM
    Author     : teguh
--%>

<%@page import="com.TA.models.lokasi"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <section class="content-header">
         <% ArrayList pelangganlist = (ArrayList)request.getAttribute("listlokasi"); %>
      <h1>
          CV Pandu Putra Sarana
      </h1>
                <div class="alert alert-success alert-dismissible se-pre-conberhasil">
                       
                          <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                          <h4><i class="icon fa fa-check"></i> Selamat !</h4>
                         Data Telah berhasil Di Hapus
                         
                        </div>
                    <div class="alert alert-danger alert-dismissible se-pre-congagal">
                          <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                          <h4><i class="icon fa fa-check"></i> Peringatan !</h4>
                          DATA GAGAL DI Hapus
                        </div>
    </section>

    <section class="content">
      <!-- /.row -->
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">Data Pelanggan</h3>

              <div class="box-tools">
                <div class="input-group input-group-sm" style="width: 150px;">
                  <button type="button" onclick="window.location.href='lokasiController?go=lokasi_add'  "class="btn btn-block btn-primary btn-sm"> <i class="fa fa-user-plus"></i>Tambah</button>

                 
                </div>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
              <table class="table table-hover">
                <tr>
                  <th>ID Lokasi</th>
                  <th>Nama Lokasi</th>
                  <th>Aksi</th>
                </tr>
         <%
                        int no = 0;
                        int  id_lokasi= 0;
                        String lokasi_namalokasi = null;
                 

                        try {
                            List<lokasi> list;
                          
                           list = pelangganlist;
                            for (lokasi lk : list) {
                                
                                id_lokasi = lk.getId_lokasi();
                                lokasi_namalokasi = lk.getLokasi_namalokasi(); 
                               
                               
                                

                    %>
                    
                  <td><%=id_lokasi%></td>
                  <td><%=lokasi_namalokasi%></td>
           
                 
                 
                  
                        <td>
                            <a href="lokasiController?go=lokasi_edit&amp;lokasi_id=<%=id_lokasi%>">  <span class="label label-warning">Rubah</span> </a>
                            <a href="lokasiController?go=lokasi_hapus&amp;lokasi_id=<%=id_lokasi%>" class="tombol-hapus">  <span class="label label-danger">Hapus</span> </a>
             
                        </td>                                 

                </tr>

                  <%
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    %>
              </table>
                    <!--<p>Total Karyawan = </p>-->
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
      </div>
    </section>