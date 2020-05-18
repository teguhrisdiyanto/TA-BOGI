<%-- 
    Document   : pelangganList
    Created on : May 16, 2020, 9:07:24 PM
    Author     : teguh
--%>



<%@page import="com.TA.models.pelanggan"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

  <section class="content-header">
         <% ArrayList pelangganlist = (ArrayList)request.getAttribute("listpelanggan"); %>
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
                  <button type="button" onclick="window.location.href='Pelanggan?go=pelanggan_add'  "class="btn btn-block btn-primary btn-sm"> <i class="fa fa-user-plus"></i> Add</button>

                </div>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
              <table class="table table-hover">
                <tr>
                  <th>id_pelanggan</th>
                  <th>pelanggan_nama</th>
                  <th>pelanggan_alamat</th>
                  <th>pelanggan_nohp</th>
                  <th>pelanggan_email</th>
                  <th>pelanggan_pekerjaan</th>
                  <th>Aksi</th>
                </tr>
         <%
                       
                        int  id_pelanggan= 0;
                        String pelanggan_nama = null;
                        String pelanggan_alamat = null;
                        String pelanggan_nohp = null;
                        String pelanggan_email = null;
                        String pelanggan_pekerjaan  = null;

                        try {
                            List<pelanggan> list;
                          
                           list = pelangganlist;
                            for (pelanggan pl : list) {
                                
                                id_pelanggan = pl.getId_pelanggan();
                                pelanggan_nama = pl.getPelanggan_nama(); 
                                pelanggan_alamat = pl.getPelanggan_alamat(); 
                                pelanggan_nohp = pl.getPelanggan_nohp(); 
                                pelanggan_email= pl.getPelanggan_email(); 
                                pelanggan_pekerjaan= pl.getPelanggan_pekerjaan();
                               
                                

                    %>
                    
                  <td><%=id_pelanggan%></td>
                  <td><%=pelanggan_nama%></td>
                  <td><%=pelanggan_alamat %></td>
                  <td><%=pelanggan_nohp%></td>
                  <td><%=pelanggan_email%></td>
                  <td><%=pelanggan_pekerjaan%></td>
                 
                 
                  
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