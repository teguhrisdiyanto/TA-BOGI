/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Transaksi;

import Controllers.LoginController;
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
            String link = request.getParameter("go");
            
            if (username != null){
                
                List<tender> list;
                List<tender> list2 = new ArrayList<>();
                switch(link){
                    case "list":
                        
                        
                           list = tend.getAll();


                                       for (tender tl : list) {
                                            tender T = new tender();
                    
                                            T.setId_tender(tl.getId_tender());
//                                            T.setTender_namatender(AES.decrypt(tl.getTender_namatender()));
                                            T.setTender_namatender(tl.getTender_namatender());
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
