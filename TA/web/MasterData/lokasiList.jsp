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
              <h3 class="box-title">Data Pelanggan</h3>

              <div class="box-tools">
                <div class="input-group input-group-sm" style="width: 150px;">
                  <button type="button" onclick="window.location.href='Karyawan?go=karyawan_add'  "class="btn btn-block btn-primary btn-sm"> <i class="fa fa-user-plus"></i> Add</button>

                 
                </div>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
              <table class="table table-hover">
                <tr>
                  <th>id_lokasi</th>
                  <th>Nama_lokasi</th>
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
                            <a href="">  <span class="label label-warning">Rubah</span> </a>
                            <a href="">  <span class="label label-danger">Hapus</span> </a>
             
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