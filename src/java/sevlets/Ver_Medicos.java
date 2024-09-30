/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sevlets;

import DAO.MedicoDAO;
import Classes.Medicos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateu
 */
public class Ver_Medicos extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Ver_Medicos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Ver_Medicos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        RequestDispatcher dispachante;
        String crmBuscar=request.getParameter("crmBuscar");
        
        MedicoDAO medicoDAO=new MedicoDAO();
        List<Medicos> listaMedicos;
        
        if(crmBuscar!=null && !crmBuscar.isEmpty()){
            listaMedicos=medicoDAO.listarMedicosPorCrm(crmBuscar);
            
           
            
        }else{
             listaMedicos=medicoDAO.listarMedicos();
            
        }
        
             request.setAttribute("listaMedicos",listaMedicos );
             dispachante=getServletContext().getRequestDispatcher("/Ver_Medicos.jsp");
             dispachante.forward(request, response);
        
        
        
        
        
        
    }

   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
