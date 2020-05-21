/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Masterdata;

import Controllers.LoginController;
import com.TA.Dao.impl.lokasiDaoImpl;
import com.TA.enkripsi.AES;
import com.TA.models.lokasi;
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
public class lokasiController extends HttpServlet {

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
                String link = request.getParameter("go");
            if (username != null){
                lokasiDaoImpl lok = new lokasiDaoImpl();
                lokasi lokdao = new lokasi();
                String lokasibagunan_id = null;
                int id ;
                int status;
                String namalokasi_bangunan = null;
                String Statusdata = null;
                 List<lokasi> list;
                 List<lokasi> list2 = new ArrayList();
                switch(link){
                    
                    case "list":
                        System.out.println("ini link" + link);
                         
                        
                        list = lok.getAll();
                        
                        for(lokasi lokend : list){
                            lokasi lokdecrypt = new lokasi();
                            lokdecrypt.setId_lokasi(lokend.getId_lokasi());
                            lokdecrypt.setLokasi_namalokasi(AES.decrypt(lokend.getLokasi_namalokasi()));
                            list2.add(lokdecrypt);
                        
                        }
                          request.setAttribute("session", username);
                          request.setAttribute("page", "lokasibangunan");
                          request.setAttribute("listlokasi",  list2);
                          rd = request.getRequestDispatcher("Home.jsp");
                          rd.forward(request, response);
                          
                          break;
                          
                          
                    case "lokasi_add":
                        
                         request.setAttribute("session", username);
                         request.setAttribute("page", "lokasidd");
                         rd = request.getRequestDispatcher("Home.jsp");
                         rd.forward(request, response);
                         
                    break;
                    
                    case "lokasi_save":
                        
                      namalokasi_bangunan = request.getParameter("lokasibangunan");
                      
                       System.out.println("ini nama Jenis Bangunan : " + namalokasi_bangunan);
                       id = lok.autonumber(lokdao);
                       
                      lokdao.setId_lokasi(id);
                      lokdao.setLokasi_namalokasi(AES.encrypt(namalokasi_bangunan));

                       status = lok.insert(lokdao);

                          if (status == 0){
                                       System.out.println("data gagal di input");
                                       Statusdata = "01";

                                   }else{

                                       System.out.println("data berhasi di input");
                                       Statusdata = "00";
                                   }

                       request.setAttribute("session", username);
                       request.setAttribute("statusdata", Statusdata);
                       request.setAttribute("page", "lokasidd");
                       rd = request.getRequestDispatcher("Home.jsp");
                       rd.forward(request, response);
                       
                       break;
                       
                    case "lokasi_edit" :
                        
                        lokasibagunan_id= request.getParameter("lokasi_id");
                        
                        id = Integer.parseInt(lokasibagunan_id);
                        lokdao = lok.getbyid(id);
                       System.out.println("ini id lok :" + lokasibagunan_id);
                       
                       
                       request.setAttribute("id", lokdao.getId_lokasi());
                       request.setAttribute("jenisbangunan", AES.decrypt(lokdao.getLokasi_namalokasi())); 
                       request.setAttribute("session", username);
                       request.setAttribute("statusdata", Statusdata);
                       request.setAttribute("page", "lokasiedit");
                       rd = request.getRequestDispatcher("Home.jsp");
                       rd.forward(request, response);
                        
                        break;
                        
                        
                    case "lokasi_editsave":
                        lokasibagunan_id= request.getParameter("lokbangunid");
                        namalokasi_bangunan = request.getParameter("Jenisbangunan");
                        
                        id = Integer.parseInt(lokasibagunan_id);
                        lokdao.setId_lokasi(id);
                        lokdao.setLokasi_namalokasi(AES.encrypt(namalokasi_bangunan));
                        
                        status = lok.update(lokdao);
                        
                          if (status == 0){
                                       System.out.println("data gagal di input");
                                       Statusdata = "01";

                                   }else{

                                       System.out.println("data berhasi di input");
                                       Statusdata = "00";
                                   }
                        
                       request.setAttribute("session", username);
                       request.setAttribute("statusdata", Statusdata);
                       request.setAttribute("page", "lokasiedit");
                       rd = request.getRequestDispatcher("Home.jsp");
                       rd.forward(request, response);
                        
                        break;
                        
                    case "lokasi_hapus":
                        
                         lokasibagunan_id= request.getParameter("lokasi_id");
                         id = Integer.parseInt(lokasibagunan_id);
                         
                         status = lok.delete(id);
                         
                              if (status == 0){
                                       System.out.println("data gagal di input");
                                       Statusdata = "01";

                                   }else{

                                       System.out.println("data berhasi di input");
                                       Statusdata = "00";
                                   }
                       list = lok.getAll();
                        
                        for(lokasi lokend : list){
                            lokasi lokdecrypt = new lokasi();
                            lokdecrypt.setId_lokasi(lokend.getId_lokasi());
                            lokdecrypt.setLokasi_namalokasi(AES.decrypt(lokend.getLokasi_namalokasi()));
                            
                            list2.add(lokdecrypt);
                        
                        }
                         request.setAttribute("session", username);
                          request.setAttribute("page", "lokasibangunan");
                          request.setAttribute("statusdata", Statusdata);
                          request.setAttribute("listlokasi",  list2);
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
