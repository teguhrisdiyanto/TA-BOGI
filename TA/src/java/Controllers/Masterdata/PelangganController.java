/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Masterdata;

import Controllers.LoginController;
import com.TA.Dao.impl.pelangganDaoImpl;
import com.TA.enkripsi.AES;
import com.TA.models.pelanggan;
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
public class PelangganController extends HttpServlet {

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
             pelanggan plu = new pelanggan();
             pelangganDaoImpl pel = new pelangganDaoImpl();
            String username = (String) request.getSession().getAttribute("username");
            String link = request.getParameter("go");
            
            if (username != null){
                
                if(link.equals("list")){
                   
                List<pelanggan> list;
                List<pelanggan> list2 = new ArrayList<>();
                list = pel.getAll();
               
           
                            for (pelanggan pl : list) {
                             pelanggan png = new pelanggan();
                                png.setId_pelanggan(pl.getId_pelanggan());              
                                png.setPelanggan_nama(AES.decrypt(pl.getPelanggan_nama()));
                                png.setPelanggan_alamat(AES.decrypt(pl.getPelanggan_alamat()));
                                png.setPelanggan_nohp(AES.decrypt(pl.getPelanggan_nohp()));
                                png.setPelanggan_email(AES.decrypt(pl.getPelanggan_email()));
                                png.setPelanggan_pekerjaan(AES.decrypt(pl.getPelanggan_pekerjaan()));

                            list2.add(png);
                            }
                         
                
                  request.setAttribute("session", username);
                  request.setAttribute("page", "pelanggan");
                  request.setAttribute("listpelanggan", list2);
                  rd = request.getRequestDispatcher("Home.jsp");
                  rd.forward(request, response);
                
                
                }else if(link.equals("pelanggan_add")){
                request.setAttribute("session", username);
                request.setAttribute("page", "pelangganadd");
                rd = request.getRequestDispatcher("Home.jsp");
                 rd.forward(request, response);
                
                }
                else if(link.equals("pelanggan_save")){
                    String nama = request.getParameter("namapelanggan");
                    String alamat = request.getParameter("alamatpelanggan");
                    String nohp = request.getParameter("nohp");
                    String email = request.getParameter("emailpelanggan");
                    String pekerjaan = request.getParameter("pekerjaan") ;
                    String Statusdata = null;
                    System.out.println("nama :" + nama);
                    System.out.println("Alamat :" + alamat);
                    System.out.println("no hp :" + nohp);
                    System.out.println("email :" + email);
                    System.out.println("pekerjaan :" + pekerjaan);
                    
                    
                    int a = pel.autonumber(plu);
                    
                        plu.setId_pelanggan(a);
                        plu.setPelanggan_nama(AES.encrypt(nama));
                        plu.setPelanggan_alamat(AES.encrypt(alamat));
                        plu.setPelanggan_nohp(AES.encrypt(nohp));
                        plu.setPelanggan_email(AES.encrypt(email));
                        plu.setPelanggan_pekerjaan(AES.encrypt(pekerjaan));
                         int status = pel.insert(plu);
                         
                         if (status == 0){
                                System.out.println("data gagal di input");
                                Statusdata = "01";

                            }else{

                                System.out.println("data berhasi di input");
                                Statusdata = "00";
                            }
                 request.setAttribute("session", username);
                 request.setAttribute("statusdata", Statusdata);
                 request.setAttribute("page", "pelangganadd");
                 rd = request.getRequestDispatcher("Home.jsp");
                 rd.forward(request, response);
                
                
                }else if(link.equals("pelanggan_edit")){
                String pelanggan_id = request.getParameter("pelanggan_id");
                System.out.println("ini id : " + pelanggan_id);
                int id = Integer.parseInt(pelanggan_id);
                pelanggan pl = new pelanggan();    
                
                
                pl = pel.getbyid(id);
                
                request.setAttribute("id", pelanggan_id);
                request.setAttribute("namapelanggan", AES.decrypt(pl.getPelanggan_nama()));
                request.setAttribute("alamatpelanggan", AES.decrypt(pl.getPelanggan_alamat()));
                request.setAttribute("notlp", AES.decrypt(pl.getPelanggan_nohp()));
                request.setAttribute("emailpelanggan", AES.decrypt(pl.getPelanggan_email()));
                request.setAttribute("pekerjaan", AES.decrypt(pl.getPelanggan_pekerjaan()));
                
                request.setAttribute("session", username);
                request.setAttribute("page", "pelangganedit");
                rd = request.getRequestDispatcher("Home.jsp");
                 rd.forward(request, response);
                
                }else if(link.equals("pelanggan_editsave")){
                    String idpel = request.getParameter("pelid");
                    String nama = request.getParameter("namapelanggan");
                    String alamat = request.getParameter("alamatpelanggan");
                    String nohp = request.getParameter("nohp");
                    String email = request.getParameter("emailpelanggan");
                    String pekerjaan = request.getParameter("pekerjaan") ;
                    String Statusdata = null;
                    int id = Integer.parseInt(idpel);
                    System.out.println("id :" + id);
                    System.out.println("nama :" + nama);
                    System.out.println("Alamat :" + alamat);
                    System.out.println("no hp :" + nohp);
                    System.out.println("email :" + email);
                    System.out.println("pekerjaan :" + pekerjaan);
                    
                        plu.setId_pelanggan(id);
                        plu.setPelanggan_nama(AES.encrypt(nama));
                        plu.setPelanggan_alamat(AES.encrypt(alamat));
                        plu.setPelanggan_nohp(AES.encrypt(nohp));
                        plu.setPelanggan_email(AES.encrypt(email));
                        plu.setPelanggan_pekerjaan(AES.encrypt(pekerjaan));
                        int status = pel.update(plu);
                        
                    if (status == 0){
                                System.out.println("data gagal di Update");
                                Statusdata = "01";

                            }else{

                                System.out.println("data berhasi di Update");
                                Statusdata = "00";
                            }
                    
                    
                 request.setAttribute("session", username);
                 request.setAttribute("statusdata", Statusdata);
                 request.setAttribute("page", "pelangganedit");
                 rd = request.getRequestDispatcher("Home.jsp");
                 rd.forward(request, response);
                
                }
                
                
                
            
            }else{
                
                 request.getSession().setAttribute("username", null);
                request.setAttribute("message","Anda Telah Logout");
                rd = request.getRequestDispatcher("login_gagal.jsp");
                 rd.forward(request, response);
            
            
            }
        } catch (Exception e){
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
