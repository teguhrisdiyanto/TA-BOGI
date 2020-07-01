<%-- 
    Document   : tenderid
    Created on : Jun 6, 2020, 8:51:50 PM
    Author     : Tri Bogi B
--%>

<%@page import="com.TA.models.cicilan"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.TA.models.tender"%>
<%@page import="java.util.List"%>
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
                    <h3 class="box-title">Detail Tender</h3>
                      <br><br>
                      <!--pelanggan-->
                    <%String namapelanggan = (String)request.getAttribute("namapelanggan");%>
                   <%String idpelanggan = (String)request.getAttribute("idpelanggan");%>
                    <%String alamatpelanggan = (String)request.getAttribute("alamatpelanggan");%>
                    <%String notlp = (String)request.getAttribute("notlp");%>
                    <%String emailpelanggan = (String)request.getAttribute("emailpelanggan");%>
                    <%String pekerjaan = (String)request.getAttribute("pekerjaan");%>
                    
                    <!--tender-->
                    <%String tanggal = (String)request.getAttribute("tanggal");%>
                    <%String notender = (String)request.getAttribute("idtender");%>
                    <%String namatender = (String)request.getAttribute("namatender");%>
                    <%String nilaikontrak = (String)request.getAttribute("nilaikontrak");%>
                    <%String nilaidp = (String)request.getAttribute("nilaidp");%>
                    <%String sisabayar = (String)request.getAttribute("sisabayar");%>
                   
                
                    <%String id_jenisbangunan = (String)request.getAttribute("idjenisbanunan");%>
                    <%String jenisbangunan = (String)request.getAttribute("jenisbangunan");%>
                    <%String id_lokasibangunan = (String)request.getAttribute("idlokasi");%>
                    <%String lokasibangunan = (String)request.getAttribute("lokasibangunan");%>
                    
                     <!--cicilan-->
                
                    <% ArrayList cicilanlist = (ArrayList)request.getAttribute("listcicilan"); %>
                    
                                 
                                            
                    <!--col 1-->
       <div class="col-md-6">
          <div class="box box-widget widget-user-2">
            <!-- Add the bg color to the header using any of the bg-* classes -->
            <div class="widget-user-header bg-yellow">
              <div class="widget-user-image">
                <img class="img-circle" src="dist/img/avatar5.png" alt="">
              </div>
              <!-- /.widget-user-image -->
              <h3 class="widget-user-username">Data Pelanggan</h3>
              <h5 class="widget-user-desc">Nama Pelanggan : <%= namapelanggan%></h5>
            </div>
            <div class="box-footer no-padding">
              <ul class="nav nav-stacked">
                <li><a href="#">No Telepon<span class="pull-right "><%= notlp%></span></a></li>
                <li><a href="#">Email Pelanggan <span class="pull-right"><%= emailpelanggan%></span></a></li>
                <li><a href="#">Pekerjaan <span class="pull-right "><%= pekerjaan%></span></a></li>
                <li><a href="#">Alamat <span class="pull-right "><%= alamatpelanggan%></span></a></li>
              </ul>
            </div>
          </div>
       </div>              
                    <div class="col-md-6">
                            <div class="box box-widget widget-user-2">
            <!-- Add the bg color to the header using any of the bg-* classes -->
            <div class="widget-user-header bg-yellow">
              <div class="widget-user-image">
                <img class="img-circle" src="dist/img/images.png" alt="">
              </div>
              <!-- /.widget-user-image -->
              <h3 class="widget-user-username">Data Tender </h3>
            <h5 class="widget-user-desc">Nama Tender : <%= namatender%></h5>
            </div>
            <div class="box-footer no-padding">
              <ul class="nav nav-stacked">
                <li><a href="#">Tanggal Tender <span class="pull-right"><%= tanggal%></span></a></li>
                <!--<li><a href="#">Nama Tender <span class="pull-right "><%= namatender%></span></a></li>-->
                <li><a href="#">Jenis Bangunan <span class="pull-right "><%= jenisbangunan%></span></a></li>
                <li><a href="#">Nilai Kontrak <span class="pull-right ">Rp.<%= nilaikontrak%></span></a></li>
                <li><a href="#">Nilai DP <span class="pull-right ">Rp.<%= nilaidp%></span></a></li>
                <% if(sisabayar.equals("0")){
                
                %> <li><a href="#">Sisa Bayar <span class="pull-right badge bg-green ">Rp.<%= sisabayar%></span></a></li>
                
                <%} else{

                    %><li><a href="#">Sisa Bayar <span class="pull-right badge bg-red ">Rp.<%= sisabayar%></span></a></li>

               <% }

                %>
                
                <li><a href="#">Lokasi <span class="pull-right "><%= lokasibangunan%></span></a></li>
              </ul>
            </div>
          </div>
                        
                    </div>

                </div>





                <!-- /.box-header -->
                <div class="box-body table-responsive no-padding">

                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
              
       <div class="col-xs-12">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">Cicilan</h3>
                      <br><br>
                      <!--pelanggan-->
              <div class="box-tools">
                <div class="input-group input-group-sm" style="width: 150px;">
              <% if(sisabayar.equals("0")){
                
            %> <button type="button "class="btn btn-block btn-primary btn-sm" disabled data-toggle="modal" data-target="#modal-info" > <i class="fa fa-user-plus"></i> Input Cicilan</button>
                
                <%} else{

                    %><button type="button  "class="btn btn-block btn-primary btn-sm" data-toggle="modal" data-target="#modal-info" > <i class="fa fa-user-plus"></i> Input Cicilan</button>

               <% }

                %>
                  

                </div>
              </div>

                </div>
                
                <div class="box-body table-responsive no-padding">
              <table class="table table-hover">
                <tr>
                   <th>ID cicilan</th>
                  <th>Tanggal Cicilan</th>
                  <th>Nominal Cicilan</th>
                  <th>Aksi</th>
                </tr>
         <%
                       
                        int  id_cicilan= 0;
                        String cicilan_tanggal = null;
                        String cicilan_nominal = null;
                        int id_tender = 0;
                        
//                        String pelanggan_pekerjaan  = null;

                        try {
                           int no = 0;
                         List<cicilan> list;
                          
                           list = cicilanlist;
                            for (cicilan cil : list) {
                                no = no + 1;
                                id_tender = cil.getId_tender();
                                id_cicilan = cil.getId_cicilan();
                                cicilan_tanggal = cil.getCicilan_tgl();
                                cicilan_nominal = cil.getCicilan_nominal();
                                id_tender = cil.getId_tender();
                                
                               
                                

                    %>
                    
                  <td><%=no%></td>
                  <td><%=cicilan_tanggal%></td>
                  <td><%=cicilan_nominal%></td>
                
                  
                  
                 
                 
                  
                        <td>
                           
                            <a href="cicilanController?go=cicilan_hapus&amp;id_cicilan=<%=id_cicilan%>&amp;id_tender=<%=id_tender%>&amp;nominal=<%=cicilan_nominal%>&amp;sisabayar=<%=sisabayar%>" class = "tombol-hapus" >  <span class="label label-danger" >Hapus</span> </a>
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
     <div class="modal modal-info fade" id="modal-info">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Input Cicilan</h4>
              </div>
          <form class="form-horizontal" id="form1" name="form1" method="post" action="cicilanController?go=cicilan_save">
              <div class="modal-body">
                  <input name="id_tender" type="hidden" value="<%= notender%>"/>
                  <input name="id_pelanggan" type="hidden" value="<%= idpelanggan%>"/>
                  <input name="id_jenisbangunan" type="hidden" value="<%= id_jenisbangunan%>"/>
                  <input name="id_lokasi" type="hidden" value="<%= id_lokasibangunan%>"/>
                 <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">Tanggal Cicilan</label>
                  
                  <div class="input-group input-group-sm">
                  <div class="col-sm-10">
                     <span class="input-group-btn">
                            <div class="input-group date">
                      
                       <div class="input-group-addon">
                            <i class="fa fa-calendar"></i>
                        </div>
                                <input type="text" name ="tanggalcicilan" class="form-control pull-right" id="datepicker" required>
                    </div>
                    </span>
                  </div>
                  </div>
                 
                </div>
                  
                  
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">saldo awal</label>
                  
                  <div class="input-group input-group-sm">
                  <div class="col-sm-10">
                     <span class="input-group-btn">
                         <input type="number" class="form-control" name="nilaikontrak" id ="nilaikontrak" size="40" maxlength="100" value=<%= sisabayar%> readonly required  onkeypress="return onlyNumberKey(event)"/>
                     
                    </span>
                  </div>
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">cicilan</label>
                  
                  <div class="input-group input-group-sm">
                  <div class="col-sm-10">
                     <span class="input-group-btn">
                         <input type="number" class="form-control" name="nilaidp" id ="nilaidp" size="40" maxlength="100"  required  onkeypress="return onlyNumberKey(event)"/>
                     
                    </span>
                  </div>
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">saldo akhir</label>
                  
                  <div class="input-group input-group-sm">
                  <div class="col-sm-10">
                     <span class="input-group-btn">
                         <input type="text" class="form-control" name="sisabayar" id ="sisabayar" size="40" maxlength="100" value="${noTlp}" placeholder="saldo Akhir" required readonly onkeypress="return onlyNumberKey(event)"/>
                     
                    </span>
                  </div>
                  </div>
                </div>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-outline pull-left" data-dismiss="modal">KELUAR</button>
                <button type="submit" class="btn btn-outline">SIMPAN</button>
              </div>
          </form>
            </div>
            <!-- /.modal-content -->
          </div>
          <!-- /.modal-dialog -->
        </div>




                <!-- /.box-header -->
                <div class="box-body table-responsive no-padding">

                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
    </div>
</section>