/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Transaksi;

import Controllers.LoginController;
import com.TA.Dao.impl.cicilanDaoImpl;
import com.TA.Dao.impl.tenderDaoImpl;
import com.TA.enkripsi.AES;
import com.TA.models.cicilan;
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
 * @author teguh
 */
public class cicilanController extends HttpServlet {

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
        try  {
            
            String username = (String) request.getSession().getAttribute("username");
           cicilanDaoImpl cil2 = new cicilanDaoImpl();
           tenderDaoImpl mtender = new tenderDaoImpl();
           cicilan mcicilan = new cicilan();
           tender tn = new tender();
            String link = request.getParameter("go");
            String tender_id = null;
            if(username != null){
                
                switch(link){
                
                case"cicilan_save":
                         List<cicilan> listcicilan;
                        List<cicilan> listcicilan2 = new ArrayList<>();
                        
                        tender_id= request.getParameter("id_tender");
                        String nilaikontrak = request.getParameter("nilaikontrak");
                        String nilaidp = request.getParameter("nilaidp");
                        String tangalcicilan = request.getParameter("tanggalcicilan");
                        String sisabayar = request.getParameter("sisabayar");
                        String id_pelanggan = request.getParameter("id_pelanggan");
                        String id_jenisbangun = request.getParameter("id_jenisbangunan");
                        String id_lokasi = request.getParameter("id_lokasi");
                        
                        
                        
                        
                                    System.out.println(id_pelanggan);
                                    System.out.println(id_jenisbangun);
                                    System.out.println(id_lokasi);
                        
                       int id_cicilan = cil2.autonumber(mcicilan);
                       System.out.println("id pelanggan :" + id_pelanggan );
                       mcicilan.setId_cicilan(id_cicilan);
                       mcicilan.setCicilan_tgl(AES.encrypt(tangalcicilan));
                       mcicilan.setCicilan_nominal(AES.encrypt(nilaidp));
                       mcicilan.setId_tender(Integer.parseInt(tender_id));
                       mcicilan.setId_pelanggan(Integer.parseInt(id_pelanggan));
                       mcicilan.setId_jenisbangunan(Integer.parseInt(id_jenisbangun));
                       mcicilan.setId_lokasi(Integer.parseInt(id_lokasi));
                       
                       
                       
                       tn.setId_tender(Integer.parseInt(tender_id));
                       tn.setSisabayar(AES.encrypt(sisabayar));
                       
                       
                        String Statusdata = null;
                        int statuscicilan = cil2.insert(mcicilan);
                        int statustender = mtender.updatesisabayar(tn);
                        
                         if (statuscicilan == 1 && statustender ==1 ){
                                System.out.println("data berhasil di input");
                                Statusdata = "00";
                            }else{
                                System.out.println("data gagal di input");
                                 Statusdata = "01";
                            }
       
                      
                        System.out.println("ini id csebelumpasrse  : " + tender_id);
                        int id  = Integer.parseInt(tender_id);
                        System.out.println("ini id coy  : " + id);
                          
                          
                          tn = mtender.getbyid(id);
                          
                          
                            listcicilan = cil2.getAll(id);


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
                        request.setAttribute("statusdata", Statusdata);
                
                        
                             request.setAttribute("session", username);
                             request.setAttribute("page", "tenderid");
//                             request.setAttribute("listtender", list2);
                             rd = request.getRequestDispatcher("Home.jsp");
                             rd.forward(request, response);
                             
                             
                                    System.out.println(tender_id);
                                    System.out.println(nilaikontrak);
                                    System.out.println(nilaidp);
                                    System.out.println(sisabayar);
                                    System.out.println(id_pelanggan);
                                    System.out.println(id_jenisbangun);
                                    System.out.println(id_lokasi);
                   
                case "cicilan_hapus":
                       List<cicilan> listcicilanhapus;
                        List<cicilan> listcicilanhapus2 = new ArrayList<>();
                        
                        tender_id= request.getParameter("id_tender");
                        String nilaikontrak1 = request.getParameter("nilaikontrak");
                        String nilaidp1 = request.getParameter("nilaidp");
                        String tangalcicilan1 = request.getParameter("tanggalcicilan");
                        String sisabayar1 = request.getParameter("sisabayar");
                        String id_pelanggan1 = request.getParameter("id_pelanggan");
                        String id_jenisbangun1 = request.getParameter("id_jenisbangunan");
                        String id_lokasi1 = request.getParameter("id_lokasi");
                        
                        
                        
                        String id_cicilannd = request.getParameter("id_cicilan");
                        String id_tenderd= request.getParameter("id_tender");
                        String nominal = request.getParameter("nominal");
                        String sisabayars = request.getParameter("sisabayar");
                       int saldo = Integer.parseInt(sisabayars);
                       int refund = Integer.parseInt(nominal);
                       int sisasaldo = saldo + refund;
                        tn.setId_tender(Integer.parseInt(tender_id));
                        tn.setSisabayar(AES.encrypt(Integer.toString(sisasaldo)));

                       int statusdelcicilan = cil2.delete(Integer.parseInt(id_cicilannd));
                       int statusSaldo = mtender.updatesisabayar(tn);

                        if (statusdelcicilan == 1 && statusSaldo ==1 ){
                                       System.out.println("data berhasil di input");
                                       Statusdata = "00";
                                   }else{
                                       System.out.println("data gagal di input");
                                        Statusdata = "01";
                                   }

                 
                 
                 
                
                
                                     System.out.println(id_cicilannd);
                                    System.out.println(id_tenderd);
                                    System.out.println(nominal);
                                    System.out.println(sisabayars);
                                    System.out.println( " hasil refund : " +sisasaldo);
                
                        tn = mtender.getbyid(Integer.parseInt(id_tenderd));
                         
                          
                            listcicilanhapus= cil2.getAll(Integer.parseInt(id_tenderd));


                                       for (cicilan cl : listcicilanhapus) {
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

                                       listcicilanhapus2.add(cli);
                                       }
                          
                          
                          
//                          Gson gson = new Gson();
                          
//                          System.out.println("ini json controller" + gson.toJson(tn));
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
                        request.setAttribute("listcicilan", listcicilanhapus2);
                        request.setAttribute("idtender", tender_id);
                        request.setAttribute("idpelanggan", Integer.toString(tn.getId_pelangaan()));
                        request.setAttribute("idjenisbanunan",Integer.toString(tn.getId_jenisbangun()));
                        request.setAttribute("idlokasi", Integer.toString(tn.getId_lokasi()));
                        request.setAttribute("statusdata", Statusdata);
                
                        
                             request.setAttribute("session", username);
                             request.setAttribute("page", "tenderid");
//                             request.setAttribute("listtender", list2);
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
