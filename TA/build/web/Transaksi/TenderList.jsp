<%-- 
    Document   : TenderList
    Created on : Jun 6, 2020, 11:10:05 PM
    Author     : AGITeam 5
--%>

<%@page import="com.TA.models.tender"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <section class="content-header">
         <% ArrayList Tenderlist = (ArrayList)request.getAttribute("listtender"); %>
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
                  <button type="button" onclick="window.location.href='Pelanggan?go=pelanggan_add'  "class="btn btn-block btn-primary btn-sm"> <i class="fa fa-user-plus"></i>Tambah</button>

                </div>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
              <table class="table table-hover">
                <tr>
                   <th>ID Tender</th>
                  <th>Nama Tender</th>
                  <th>Nama Pelanggan</th>
                  <th>Lokasi</th>
                  <th>Jenis Bangunan</th>
                  <th>Aksi</th>
                </tr>
         <%
                       
                        int  id_tender= 0;
                        String nama_tender = null;
                        String pelanggan_nama = null;
                        String lokasi = null;
                        String jenis_bangunan = null;
                        String pelanggan_email = null;
//                        String pelanggan_pekerjaan  = null;

                        try {
                            List<tender> list;
                          
                           list = Tenderlist;
                            for (tender pl : list) {
                                id_tender = pl.getId_tender();
                                nama_tender = pl.getTender_namatender();
                                pelanggan_nama = pl.getPelanggan().getPelanggan_nama(); 
                                lokasi = pl.getLokasi().getLokasi_namalokasi(); 
                                jenis_bangunan = pl.getJenis_Bangunan().getJenisbangun_nama(); 
                               
                               
                                

                    %>
                    
                  <td><%=id_tender%></td>
                  <td><%=nama_tender%></td>
                  <td><%=pelanggan_nama%></td>
                  <td><%=lokasi %></td>
                  <td><%=jenis_bangunan%></td>
                  
                 
                 
                  
                        <td>
                           <a href="Pelanggan?go=pelanggan_edit&amp;pelanggan_id=<%=id_tender%>">  <span class="label label-warning">Rubah</span> </a>
                            <a href="Pelanggan?go=pelanggan_hapus&amp;pelanggan_id=<%=id_tender%>" class = "tombol-hapus" >  <span class="label label-danger" >Hapus</span> </a>
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
