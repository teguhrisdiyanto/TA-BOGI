/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Transaksi;

import Controllers.LoginController;
import com.TA.Dao.impl.cicilanDaoImpl;
import com.TA.Dao.impl.jenisBangunanDaoImpl;
import com.TA.Dao.impl.lokasiDaoImpl;
import com.TA.Dao.impl.pelangganDaoImpl;
import com.TA.Dao.impl.tenderDaoImpl;
import com.TA.enkripsi.AES;
import com.TA.models.cicilan;
import com.TA.models.jenisBangunan;
import com.TA.models.lokasi;
import com.TA.models.pelanggan;
import com.TA.models.tender;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AGITeam 5
 */
public class tenderController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
      RequestDispatcher rd;
        try {
            String username = (String) request.getSession().getAttribute("username");
            tenderDaoImpl tend = new tenderDaoImpl();
            pelangganDaoImpl pel = new pelangganDaoImpl();
            jenisBangunanDaoImpl jenDao = new jenisBangunanDaoImpl();
            lokasiDaoImpl lokDao = new lokasiDaoImpl();
            String link = request.getParameter("go");
            String tender_id = null;
            if (username != null){
                
                List<tender> list;
                List<tender> list2 = new ArrayList<>();
                switch(link){
                    
                    case "list":
                        
                        
                           list = tend.getAll();


                                       for (tender tl : list) {
                                            tender T = new tender();
                    
                                            T.setId_tender(tl.getId_tender());
                                            T.setTender_namatender(AES.decrypt(tl.getTender_namatender()));
//                                            T.setTender_namatender(tl.getTender_namatender());
                                            T.setTender_tanggaltender(tl.getTender_tanggaltender());
                                            
                                            pelanggan P = new pelanggan();
                                            P.setPelanggan_nama(AES.decrypt(tl.getPelanggan().getPelanggan_nama()));
                                            T.setPelanggan(P);
                                            
                                            lokasi L = new lokasi();
                                            L.setLokasi_namalokasi(AES.decrypt(tl.getLokasi().getLokasi_namalokasi()));
                                            T.setLokasi(L);
                                            
                                            
                                            jenisBangunan J = new jenisBangunan();
                                            J.setJenisbangun_nama(AES.decrypt(tl.getJenis_Bangunan().getJenisbangun_nama()));
                                            T.setJenis_Bangunan(J);
                                          

                                       list2.add(T);
                                       }


                             request.setAttribute("session", username);
                             request.setAttribute("page", "tender");
                             request.setAttribute("listtender", list2);
                             rd = request.getRequestDispatcher("Home.jsp");
                             rd.forward(request, response);
                
                    case "tender_detail":
                        List<cicilan> listcicilan;
                        List<cicilan> listcicilan2 = new ArrayList<>();
                        
                        tender_id= request.getParameter("tender_id");
                        int id  = Integer.parseInt(tender_id);
                        System.out.println("ini id coy  : " + id);
                          tender tn = new tender();
                          
                          tn = tend.getbyid(id);
                          cicilanDaoImpl cil = new cicilanDaoImpl();
                          
                            listcicilan = cil.getAll(id);


                                       for (cicilan cl : listcicilan) {
                                        cicilan cli = new cicilan();
                                        cli.setId_cicilan(cl.getId_cicilan());
                                        cli.setCicilan_tgl(AES.decrypt(cl.getCicilan_tgl()));
                                        cli.setCicilan_nominal(AES.decrypt(cl.getCicilan_nominal()));
                                        cli.setId_tender(cl.getId_tender());
                                        
//                                           png.setId_pelanggan(pl.getId_pelanggan());              
//                                           png.setPelanggan_nama(AES.decrypt(pl.getPelanggan_nama()));
//                                           png.setPelanggan_alamat(AES.decrypt(pl.getPelanggan_alamat()));
//                                           png.setPelanggan_nohp(AES.decrypt(pl.getPelanggan_nohp()));
//                                           png.setPelanggan_email(AES.decrypt(pl.getPelanggan_email()));
//                                           png.setPelanggan_pekerjaan(AES.decrypt(pl.getPelanggan_pekerjaan()));

                                       listcicilan2.add(cli);
                                       }
                          
                          
                          
                          Gson gson = new Gson();
                          
                          System.out.println("ini json controller" + gson.toJson(tn));
                        request.setAttribute("tanggal",AES.decrypt(tn.getTender_tanggaltender()));
                        request.setAttribute("namatender", AES.decrypt(tn.getTender_namatender()));
                        request.setAttribute("nilaikontrak", AES.decrypt(tn.getTender_nilaikontrak()));
                        request.setAttribute("nilaidp", AES.decrypt(tn.getTender_nilaidp()));
                        request.setAttribute("sisabayar", AES.decrypt(tn.getSisabayar()));
                        request.setAttribute("namapelanggan", AES.decrypt(tn.getPelanggan().getPelanggan_nama()));
                        request.setAttribute("alamatpelanggan", AES.decrypt(tn.getPelanggan().getPelanggan_alamat()));
                        request.setAttribute("notlp", AES.decrypt(tn.getPelanggan().getPelanggan_nohp()));
                        request.setAttribute("emailpelanggan", AES.decrypt(tn.getPelanggan().getPelanggan_email()));
                        request.setAttribute("pekerjaan", AES.decrypt(tn.getPelanggan().getPelanggan_pekerjaan()));
                        request.setAttribute("jenisbangunan", AES.decrypt(tn.getJenis_Bangunan().getJenisbangun_nama()));
                        request.setAttribute("lokasibangunan", AES.decrypt(tn.getLokasi().getLokasi_namalokasi()));
                        request.setAttribute("listcicilan", listcicilan2);
                        request.setAttribute("idtender", tender_id);
                        request.setAttribute("idpelanggan", Integer.toString(tn.getId_pelangaan()));
                        request.setAttribute("idjenisbanunan",Integer.toString(tn.getId_jenisbangun()));
                        request.setAttribute("idlokasi", Integer.toString(tn.getId_lokasi()));
                
                        
                             request.setAttribute("session", username);
                             request.setAttribute("page", "tenderid");
//                             request.setAttribute("listtender", list2);
                             rd = request.getRequestDispatcher("Home.jsp");
                             rd.forward(request, response);
                             
                    case "tambah_tender":
                         List<pelanggan> listpel;
                         List<jenisBangunan> lisjen;
                         List<lokasi> listlok;
                         List<pelanggan> listpeldecr = new ArrayList<>();
                         List<jenisBangunan> listjendecr = new ArrayList<>();
                         List<lokasi> listlokdecr = new ArrayList<>();
                          listpel = pel.getAll();
                          lisjen = jenDao.getAll();
                          listlok = lokDao.getAll();


                                       for (pelanggan pl :listpel) {
                                        pelanggan png = new pelanggan();
                                           png.setId_pelanggan(pl.getId_pelanggan());              
                                           png.setPelanggan_nama(AES.decrypt(pl.getPelanggan_nama()));

                                       listpeldecr.add(png);
                                       }
                                       
                                       
                                       for (jenisBangunan je :lisjen) {
                                        jenisBangunan jen = new jenisBangunan();
                                           jen.setId_jenisbangun(je.getId_jenisbangun());              
                                           jen.setJenisbangun_nama(AES.decrypt(je.getJenisbangun_nama()));

                                       listjendecr.add(jen);
                                       }
                                       
                                       for (lokasi lock : listlok) {
                                       lokasi lok = new lokasi();
                                           lok.setId_lokasi(lock.getId_lokasi());              
                                           lok.setLokasi_namalokasi(AES.decrypt(lock.getLokasi_namalokasi()));

                                       listlokdecr.add(lok);
                                       }
                                       
                                       
                        
                             request.setAttribute("session", username);
                             request.setAttribute("page", "tambahtender");
                             request.setAttribute("listpel", listpeldecr);
                             request.setAttribute("listjen", listjendecr);
                             request.setAttribute("listlok", listlokdecr);
                             
                             rd = request.getRequestDispatcher("Home.jsp");
                             rd.forward(request, response);
                    
                    case "tender_edit":
                        tender_id= request.getParameter("tender_id");
                        int id_edit  = Integer.parseInt(tender_id);
                        System.out.println("ini id edit coy   : " + id_edit);
                         List<pelanggan> listpeledit;
                         List<jenisBangunan> lisjenedit;
                         List<lokasi> listlokedit;
                         List<pelanggan> listpeldecredit = new ArrayList<>();
                         List<jenisBangunan> listjendecredit = new ArrayList<>();
                         List<lokasi> listlokdecredit = new ArrayList<>();
                          listpel = pel.getAll();
                          lisjen = jenDao.getAll();
                          listlok = lokDao.getAll();


                                       for (pelanggan pl :listpel) {
                                        pelanggan png = new pelanggan();
                                           png.setId_pelanggan(pl.getId_pelanggan());              
                                           png.setPelanggan_nama(AES.decrypt(pl.getPelanggan_nama()));

                                       listpeldecredit.add(png);
                                       }
                                       
                                       
                                       for (jenisBangunan je :lisjen) {
                                        jenisBangunan jen = new jenisBangunan();
                                           jen.setId_jenisbangun(je.getId_jenisbangun());              
                                           jen.setJenisbangun_nama(AES.decrypt(je.getJenisbangun_nama()));

                                       listjendecredit.add(jen);
                                       }
                                       
                                       for (lokasi lock : listlok) {
                                       lokasi lok = new lokasi();
                                           lok.setId_lokasi(lock.getId_lokasi());              
                                           lok.setLokasi_namalokasi(AES.decrypt(lock.getLokasi_namalokasi()));

                                       listlokdecredit.add(lok);
                                       }
                                       
                                       
                        
                                
                                tn = tend.getbyid(id_edit);
                             
                            request.setAttribute("id_tender",tn.getId_tender());
                            request.setAttribute("tanggal",AES.decrypt(tn.getTender_tanggaltender()));
                            request.setAttribute("namatender", AES.decrypt(tn.getTender_namatender()));
                            request.setAttribute("id_pelanggan", Integer.toString(tn.getId_pelangaan()));
                            request.setAttribute("namapelanggan", AES.decrypt(tn.getPelanggan().getPelanggan_nama()));
                            request.setAttribute("id_jenisbangun", Integer.toString(tn.getId_jenisbangun()));
                            request.setAttribute("jenisbangunan", AES.decrypt(tn.getJenis_Bangunan().getJenisbangun_nama()));
                            request.setAttribute("id_lokasi", Integer.toString(tn.getId_lokasi()));
                            request.setAttribute("lokasibangunan", AES.decrypt(tn.getLokasi().getLokasi_namalokasi()));
                            request.setAttribute("session", username);
                             request.setAttribute("page", "edittender");
                             request.setAttribute("listpel", listpeldecredit);
                             request.setAttribute("listjen", listjendecredit);
                             request.setAttribute("listlok", listlokdecredit);
                             
                             rd = request.getRequestDispatcher("Home.jsp");
                             rd.forward(request, response);
                             
                    case "tender_save" :
                        
                            String namatender = request.getParameter("namatender");
                            String nama_pelanggan = request.getParameter("nama_pelanggan");
                            String jenis_bangunan = request.getParameter("jenis_bangunan");
                            String lokasi = request.getParameter("lokasi");
                            String nilaikontrak = request.getParameter("nilaikontrak") ;
                            String nilaidp = request.getParameter("nilaidp") ;
                            String sisabayar = request.getParameter("sisabayar") ;
                            String tanggaltender = request.getParameter("tanggalntender") ;
                            tender Mten = new tender();
                            
                            int id_tender = tend.autonumber(Mten);
                                    
                            Mten.setId_tender(id_tender);
                            Mten.setId_pelangaan(Integer.parseInt(nama_pelanggan));
                            Mten.setId_jenisbangun(Integer.parseInt(jenis_bangunan));
                            Mten.setId_lokasi(Integer.parseInt(lokasi));
                            Mten.setTender_tanggaltender(AES.encrypt(tanggaltender));
                            Mten.setTender_namatender(AES.encrypt(namatender));
                            Mten.setTender_nilaikontrak(AES.encrypt(nilaikontrak));
                            Mten.setTender_nilaidp(AES.encrypt(nilaidp));
                            Mten.setSisabayar(AES.encrypt(sisabayar));

                            int status = tend.insert(Mten);
                            String Statusdata = null;

                            if (status == 1){
                                System.out.println("data berhasil di input");
                                Statusdata = "00";
                            }else{
                                System.out.println("data gagal di input");
                                 Statusdata = "01";
                            }
                            
                         List<pelanggan> listpelsave;
                         List<jenisBangunan> lisjensave;
                         List<lokasi> listloksave;
                         List<pelanggan> listpeldecrsave = new ArrayList<>();
                         List<jenisBangunan> listjendecrsave = new ArrayList<>();
                         List<lokasi> listlokdecrsave = new ArrayList<>();
                          listpel = pel.getAll();
                          lisjen = jenDao.getAll();
                          listlok = lokDao.getAll();


                                       for (pelanggan pl :listpel) {
                                        pelanggan png = new pelanggan();
                                           png.setId_pelanggan(pl.getId_pelanggan());              
                                           png.setPelanggan_nama(AES.decrypt(pl.getPelanggan_nama()));

                                       listpeldecrsave.add(png);
                                       }
                                       
                                       
                                       for (jenisBangunan je :lisjen) {
                                        jenisBangunan jen = new jenisBangunan();
                                           jen.setId_jenisbangun(je.getId_jenisbangun());              
                                           jen.setJenisbangun_nama(AES.decrypt(je.getJenisbangun_nama()));

                                       listjendecrsave.add(jen);
                                       }
                                       
                                       for (lokasi lock : listlok) {
                                       lokasi lok = new lokasi();
                                           lok.setId_lokasi(lock.getId_lokasi());              
                                           lok.setLokasi_namalokasi(AES.decrypt(lock.getLokasi_namalokasi()));

                                       listlokdecrsave.add(lok);
                                       }
                                       
                                    System.out.println(namatender);
                                    System.out.println(nama_pelanggan);
                                    System.out.println(jenis_bangunan);
                                    System.out.println(lokasi);
                                    System.out.println(tanggaltender);
                                    System.out.println(nilaikontrak);
                                    System.out.println(nilaidp);
                                    System.out.println(sisabayar);

                         request.setAttribute("session", username);
                         request.setAttribute("statusdata", Statusdata);
                         request.setAttribute("page", "tambahtender");
                         request.setAttribute("listpel", listpeldecrsave);
                         request.setAttribute("listjen", listjendecrsave);
                         request.setAttribute("listlok", listlokdecrsave);
                         rd = request.getRequestDispatcher("Home.jsp");
                         rd.forward(request, response);
                           
                    case "tender_saveedit":
                        
                            String idenderedit = request.getParameter("id_tender");
                            String namatenderedit = request.getParameter("namatender");
                            String nama_pelangganedit = request.getParameter("nama_pelanggan");
                            String jenis_bangunanedit = request.getParameter("jenis_bangunan");
                            String lokasiedit = request.getParameter("lokasi");
                            String tanggaltenderedit = request.getParameter("tanggalntender") ;
                            
                            tender Mtenderdit = new tender();
                            
                            Mtenderdit.setId_tender(Integer.parseInt(idenderedit));
                            Mtenderdit.setTender_namatender(AES.encrypt(namatenderedit));
                            Mtenderdit.setId_pelangaan(Integer.parseInt(nama_pelangganedit));
                            Mtenderdit.setId_jenisbangun(Integer.parseInt(jenis_bangunanedit));
                            Mtenderdit.setId_lokasi(Integer.parseInt(lokasiedit));
                            Mtenderdit.setTender_tanggaltender(AES.encrypt(tanggaltenderedit));
                            
                            
                          
                            
                           int statusedit = tend.update(Mtenderdit);
//                            String Statusdata = null;

                            if (statusedit == 1){
                                System.out.println("data berhasil di input");
                                Statusdata = "00";
                            }else{
                                System.out.println("data gagal di input");
                                 Statusdata = "01";
                            }
                            
                          
                        System.out.println("ini id edit coy   : " + idenderedit);
                         List<pelanggan> listpeleditsave;
                         List<jenisBangunan> lisjeneditsave;
                         List<lokasi> listlokeditsave;
                         List<pelanggan> listpeldecreditsave = new ArrayList<>();
                         List<jenisBangunan> listjendecreditsave = new ArrayList<>();
                         List<lokasi> listlokdecreditsave = new ArrayList<>();
                          listpel = pel.getAll();
                          lisjen = jenDao.getAll();
                          listlok = lokDao.getAll();


                                       for (pelanggan pl :listpel) {
                                        pelanggan png = new pelanggan();
                                           png.setId_pelanggan(pl.getId_pelanggan());              
                                           png.setPelanggan_nama(AES.decrypt(pl.getPelanggan_nama()));

                                       listpeldecreditsave.add(png);
                                       }
                                       
                                       
                                       for (jenisBangunan je :lisjen) {
                                        jenisBangunan jen = new jenisBangunan();
                                           jen.setId_jenisbangun(je.getId_jenisbangun());              
                                           jen.setJenisbangun_nama(AES.decrypt(je.getJenisbangun_nama()));

                                       listjendecreditsave.add(jen);
                                       }
                                       
                                       for (lokasi lock : listlok) {
                                       lokasi lok = new lokasi();
                                           lok.setId_lokasi(lock.getId_lokasi());              
                                           lok.setLokasi_namalokasi(AES.decrypt(lock.getLokasi_namalokasi()));

                                       listlokdecreditsave.add(lok);
                                       }
                                       
                                       
                        
                                
                                tn = tend.getbyid(Integer.parseInt(idenderedit));
                             
                             request.setAttribute("id_tender",tn.getId_tender());
                             request.setAttribute("tanggal",AES.decrypt(tn.getTender_tanggaltender()));
                             request.setAttribute("namatender", AES.decrypt(tn.getTender_namatender()));
                             request.setAttribute("id_pelanggan", Integer.toString(tn.getId_pelangaan()));
                             request.setAttribute("namapelanggan", AES.decrypt(tn.getPelanggan().getPelanggan_nama()));
                             request.setAttribute("id_jenisbangun", Integer.toString(tn.getId_jenisbangun()));
                             request.setAttribute("jenisbangunan", AES.decrypt(tn.getJenis_Bangunan().getJenisbangun_nama()));
                             request.setAttribute("id_lokasi", Integer.toString(tn.getId_lokasi()));
                             request.setAttribute("lokasibangunan", AES.decrypt(tn.getLokasi().getLokasi_namalokasi()));
                             request.setAttribute("session", username);
                             request.setAttribute("page", "edittender");
                             request.setAttribute("listpel", listpeldecreditsave);
                             request.setAttribute("listjen", listjendecreditsave);
                             request.setAttribute("listlok", listlokdecreditsave);
                             request.setAttribute("statusdata", Statusdata);
                             rd = request.getRequestDispatcher("Home.jsp");
                             rd.forward(request, response);
                            
                            
                            
                            
                        
                                    System.out.println(idenderedit);
                                    System.out.println(namatenderedit);
                                    System.out.println(nama_pelangganedit);
                                    System.out.println(jenis_bangunanedit);
                                    System.out.println(lokasiedit);
                                    System.out.println(tanggaltenderedit);
                                  
                    case "tender_delete" :
                        
                          tender_id= request.getParameter("tender_id");
                            
                            id = Integer.parseInt(tender_id);
                            System.out.println("id :" + id);


                                status = tend.delete(id);

                            if (status == 0){
                                        System.out.println("data gagal di Update");
                                        Statusdata = "01";

                                    }else{

                                        System.out.println("data berhasi di Update");
                                        Statusdata = "00";
                                    }
                         list = tend.getAll();


                                       for (tender tl : list) {
                                            tender T = new tender();
                    
                                            T.setId_tender(tl.getId_tender());
                                            T.setTender_namatender(AES.decrypt(tl.getTender_namatender()));
//                                            T.setTender_namatender(tl.getTender_namatender());
                                            T.setTender_tanggaltender(tl.getTender_tanggaltender());
                                            
                                            pelanggan P = new pelanggan();
                                            P.setPelanggan_nama(AES.decrypt(tl.getPelanggan().getPelanggan_nama()));
                                            T.setPelanggan(P);
                                            
                                            lokasi L = new lokasi();
                                            L.setLokasi_namalokasi(AES.decrypt(tl.getLokasi().getLokasi_namalokasi()));
                                            T.setLokasi(L);
                                            
                                            
                                            jenisBangunan J = new jenisBangunan();
                                            J.setJenisbangun_nama(AES.decrypt(tl.getJenis_Bangunan().getJenisbangun_nama()));
                                            T.setJenis_Bangunan(J);
                                          

                                       list2.add(T);
                                       }


                             request.setAttribute("session", username);
                             request.setAttribute("page", "tender");
                             request.setAttribute("listtender", list2);
                             request.setAttribute("statusdata", Statusdata);
                             rd = request.getRequestDispatcher("Home.jsp");
                             rd.forward(request, response);
                      
                      
                }
                

                
            }else{
             request.getSession().setAttribute("username", null);
             request.setAttribute("message","Anda Telah Logout");
             rd = request.getRequestDispatcher("login_gagal.jsp");
             rd.forward(request, response);
            
            
            }
            
            
            
        }
        catch (Exception e){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, e);
        }   finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
