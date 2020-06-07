<%-- 
    Document   : tenderid
    Created on : Jun 6, 2020, 8:51:50 PM
    Author     : Tri Bogi B
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
                    <h3 class="box-title">Detail Tender</h3>
                      <br><br>
                      <!--pelanggan-->
                    <%String namapelanggan = (String)request.getAttribute("namapelanggan");%>
                    <%String alamatpelanggan = (String)request.getAttribute("alamatpelanggan");%>
                    <%String notlp = (String)request.getAttribute("notlp");%>
                    <%String emailpelanggan = (String)request.getAttribute("emailpelanggan");%>
                    <%String pekerjaan = (String)request.getAttribute("pekerjaan");%>
                    
                    <!--tender-->
                    <%long tanggal = (long)request.getAttribute("tanggal");%>
                    <%String namatender = (String)request.getAttribute("namatender");%>
                    <%String nilaikontrak = (String)request.getAttribute("nilaikontrak");%>
                    <%String nilaidp = (String)request.getAttribute("nilaidp");%>
                    <%String alamat = (String)request.getAttribute("alamat");%>
                    
                    
                    <%String jenisbangunan = (String)request.getAttribute("jenisbangunan");%>
                    <%String lokasibangunan = (String)request.getAttribute("lokasibangunan");%>
                  
                    
                                 
                                            
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
                <li><a href="#">No Tlp<span class="pull-right "><%= notlp%></span></a></li>
                <li><a href="#">Emailpelanggan <span class="pull-right"><%= emailpelanggan%></span></a></li>
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
            <h5 class="widget-user-desc">Nama Pelanggan : <%= namapelanggan%></h5>
            </div>
            <div class="box-footer no-padding">
              <ul class="nav nav-stacked">
                <li><a href="#">Tanggaln Tender <span class="pull-right"><%= tanggal%></span></a></li>
                <li><a href="#">Nama Tender <span class="pull-right "><%= namatender%></span></a></li>
                <li><a href="#">Jenis Bangunan <span class="pull-right "><%= jenisbangunan%></span></a></li>
                <li><a href="#">Nilai Kontrak <span class="pull-right ">Rp.<%= nilaikontrak%></span></a></li>
                <li><a href="#">Nilai DP <span class="pull-right ">Rp.<%= nilaidp%></span></a></li>
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
    </div>
</section>