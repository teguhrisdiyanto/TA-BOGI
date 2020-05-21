/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Masterdata;

import Controllers.LoginController;
import com.TA.Dao.impl.jenisBangunanDaoImpl;
import com.TA.enkripsi.AES;
import com.TA.models.jenisBangunan;
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
public class jenisBangunanController extends HttpServlet {

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
            String link = request.getParameter("go");
            String username = (String) request.getSession().getAttribute("username");
            jenisBangunanDaoImpl jen = new jenisBangunanDaoImpl();
            jenisBangunan jenisbangun = new jenisBangunan();
            
            if (username != null){
                String jenisbangunan_id = null;
                int id ;
                int status;
                String namajenis_bangunan = null;
                String Statusdata = null;
                List<jenisBangunan> list;
                List <jenisBangunan> list2 = new ArrayList();
                switch (link){
                
                    case "list":
                        
                            
                            list = jen.getAll();
                                for (jenisBangunan jenB : list){
                                    jenisBangunan jb = new jenisBangunan();
                                    jb.setId_jenisbangun(jenB.getId_jenisbangun());
                                    jb.setJenisbangun_nama(AES.decrypt(jenB.getJenisbangun_nama()));

                                    list2.add(jb);

                                }

                              request.setAttribute("session", username);
                              request.setAttribute("page", "jenisbangunan");
                              request.setAttribute("listjenisbangunan",  list2);
                              rd = request.getRequestDispatcher("Home.jsp");
                              rd.forward(request, response);
                              System.out.println("ini switch link" + link);
                              break;
                              
                    case "jenisbangunan_add" :
                        
                            request.setAttribute("session", username);
                            request.setAttribute("page", "jenisbangunanadd");
                            rd = request.getRequestDispatcher("Home.jsp");
                            rd.forward(request, response);
             
                            break;
                            
                    case "jenisbangunan_edit":
                        
                            System.out.println("ini switch link" + link);
                             jenisbangunan_id= request.getParameter("jenisbangunan_id");
                             id  = Integer.parseInt(jenisbangunan_id);
                             jenisbangun = jen.getbyid(id);
                             System.out.println("ini id : " + jenisbangunan_id);
                             
                             
                             request.setAttribute("session", username);
                             request.setAttribute("id", jenisbangunan_id);
                             request.setAttribute("jenisbangunan", AES.decrypt(jenisbangun.getJenisbangun_nama()));
//                                request.setAttribute("statusdata", Statusdata);
                             request.setAttribute("page", "jenisbangunananedit");
                             rd = request.getRequestDispatcher("Home.jsp");
                            rd.forward(request, response);
                            
                         break;
                            
                    case "jenisbangunan_save":
                        
                       namajenis_bangunan = request.getParameter("Jenisbangunan");
                      
                       System.out.println("ini nama Jenis Bangunan : " + namajenis_bangunan);
                       int a = jen.autonumber(jenisbangun);
                       jenisbangun.setId_jenisbangun(a);
                       jenisbangun.setJenisbangun_nama(AES.encrypt(namajenis_bangunan));

                       status = jen.insert(jenisbangun);

                          if (status == 0){
                                       System.out.println("data gagal di input");
                                       Statusdata = "01";

                                   }else{

                                       System.out.println("data berhasi di input");
                                       Statusdata = "00";
                                   }

                       request.setAttribute("session", username);
                       request.setAttribute("statusdata", Statusdata);
                       request.setAttribute("page", "jenisbangunanadd");
                       rd = request.getRequestDispatcher("Home.jsp");
                       rd.forward(request, response);
                       
                       break;
                       
                    case "jenisbangunan_editsave":
                        jenisbangunan_id = request.getParameter("jenbangunid");
                        namajenis_bangunan = request.getParameter("Jenisbangunan");
                        id = Integer.parseInt(jenisbangunan_id);
                        System.out.println("id :" + jenisbangunan_id);
                        System.out.println("jenis :" + namajenis_bangunan);
                        
                       jenisbangun.setId_jenisbangun(id);
                       jenisbangun.setJenisbangun_nama(AES.encrypt(namajenis_bangunan));
                       
                       status = jen.update(jenisbangun);
                       
                          if (status == 0){
                                       System.out.println("data gagal di input");
                                       Statusdata = "01";

                                   }else{

                                       System.out.println("data berhasi di input");
                                       Statusdata = "00";
                                   }
                        
                       request.setAttribute("session", username);
                       request.setAttribute("statusdata", Statusdata);
                       request.setAttribute("page", "jenisbangunanadd");
                       rd = request.getRequestDispatcher("Home.jsp");
                       rd.forward(request, response);
                       
                       break;
                       
                    case "jenisbangunan_hapus" :
                         jenisbangunan_id= request.getParameter("jenisbangunan_id");
                            
                            id = Integer.parseInt(jenisbangunan_id);
                            System.out.println("id :" + id);


                                status = jen.delete(id);

                            if (status == 0){
                                        System.out.println("data gagal di Update");
                                        Statusdata = "01";

                                    }else{

                                        System.out.println("data berhasi di Update");
                                        Statusdata = "00";
                                    }
                       
                            list = jen.getAll();


                                    for (jenisBangunan jnb1 : list) {
                                     jenisBangunan jnb2 = new jenisBangunan();
                                        jnb2.setId_jenisbangun(jnb1.getId_jenisbangun());              
                                        jnb2.setJenisbangun_nama(AES.decrypt(jnb1.getJenisbangun_nama()));
                                       

                                    list2.add(jnb2);
                                    }
                                    
                         request.setAttribute("session", username);
                         request.setAttribute("statusdata", Statusdata);
                         request.setAttribute("session", username);
                         request.setAttribute("page", "jenisbangunan");
                         request.setAttribute("listjenisbangunan",  list2);
                         rd = request.getRequestDispatcher("Home.jsp");
                         rd.forward(request, response);
                        
                        break;
                       
                       

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
