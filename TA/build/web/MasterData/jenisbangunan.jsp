<%-- 
    Document   : jenisbangunan
    Created on : May 16, 2020, 10:42:42 PM
    Author     : teguh
--%>

<%@page import="com.TA.models.jenisBangunan"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<section class="content-header">
         <% ArrayList jenisbangunanlist = (ArrayList)request.getAttribute("listjenisbangunan"); %>
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
              <h3 class="box-title">Data Jenis Bangunan</h3>

              <div class="box-tools">
                <div class="input-group input-group-sm" style="width: 150px;">
                  <button type="button" onclick="window.location.href='Karyawan?go=karyawan_add'  "class="btn btn-block btn-primary btn-sm"> <i class="fa fa-user-plus"></i>Tambah</button>
                </div>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
              <table class="table table-hover">
                <tr>
                  <th>ID Jenis</th>
                  <th>Jenis Bangunan</th>
                  <th>Aksi</th>
                </tr>
         <%
                        int no = 0;
                        int  id_jenis= 0;
                        String namajenis = null;
                    
                  
                       
                        
                     

                        try {
                            
                           
                            
                            List<jenisBangunan> list;
                          
                           list = jenisbangunanlist;
                            for (jenisBangunan jn : list) {
                                
                                id_jenis = jn.getId_jenisbangun();
                               namajenis = jn.getJenisbangun_nama();
                               
                                

                    %>
                    
                  <td><%=id_jenis %></td>
                  <td><%= namajenis%></td>
                
                 
                 
                  
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
