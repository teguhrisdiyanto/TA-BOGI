/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Transaksi;

import Controllers.LoginController;
import com.TA.Dao.impl.jenisBangunanDaoImpl;
import com.TA.Dao.impl.lokasiDaoImpl;
import com.TA.Dao.impl.pelangganDaoImpl;
import com.TA.Dao.impl.tenderDaoImpl;
import com.TA.enkripsi.AES;
import com.TA.models.jenisBangunan;
import com.TA.models.lokasi;
import com.TA.models.pelanggan;
import com.TA.models.tender;
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
                        
                        tender_id= request.getParameter("tender_id");
                        int id  = Integer.parseInt(tender_id);
                        System.out.println("ini id coy  : " + id);
                          tender tn = new tender();
                          tn = tend.getbyid(id);
                        request.setAttribute("tanggal", tn.getTender_tanggaltender());
                        request.setAttribute("namatender", AES.decrypt(tn.getTender_namatender()));
                        request.setAttribute("nilaikontrak", AES.decrypt(tn.getTender_nilaikontrak()));
                        request.setAttribute("nilaidp", AES.decrypt(tn.getTender_nilaidp()));
                        request.setAttribute("alamat", AES.decrypt(tn.getTender_alamat()));
                        request.setAttribute("namapelanggan", AES.decrypt(tn.getPelanggan().getPelanggan_nama()));
                        request.setAttribute("alamatpelanggan", AES.decrypt(tn.getPelanggan().getPelanggan_alamat()));
                        request.setAttribute("notlp", AES.decrypt(tn.getPelanggan().getPelanggan_nohp()));
                        request.setAttribute("emailpelanggan", AES.decrypt(tn.getPelanggan().getPelanggan_email()));
                        request.setAttribute("pekerjaan", AES.decrypt(tn.getPelanggan().getPelanggan_pekerjaan()));
                        request.setAttribute("jenisbangunan", AES.decrypt(tn.getJenis_Bangunan().getJenisbangun_nama()));
                        request.setAttribute("lokasibangunan", AES.decrypt(tn.getLokasi().getLokasi_namalokasi()));
                
                        
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
                             
                    case "tender_save" :
                        
                            String namatender = request.getParameter("namatender");
                            String nama_pelanggan = request.getParameter("nama_pelanggan");
                            String jenis_bangunan = request.getParameter("jenis_bangunan");
                            String lokasi = request.getParameter("lokasi");
                           String nilaikontrak = request.getParameter("nilaikontrak") ;
                           String nilaidp = request.getParameter("nilaidp") ;
                           String sisabayar = request.getParameter("sisabayar") ;
                           
                           System.out.println(namatender);
                           System.out.println(nama_pelanggan);
                           System.out.println(jenis_bangunan);
                           System.out.println(lokasi);
                           System.out.println(nilaidp);
                           System.out.println(sisabayar);
                        
                        
                        
                      
                      
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
