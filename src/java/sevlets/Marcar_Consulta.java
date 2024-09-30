/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sevlets;

import DAO.PacienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateu
 */
public class Marcar_Consulta extends HttpServlet {

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
            out.println("<title>Servlet Marcar_Consulta</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Marca  _Consulta at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
       
        
        
        String cpf=request.getParameter("cpf");
        PacienteDAO pacienteDAO=new PacienteDAO();
        String resultado; 
        
        
        if (cpf == null){
            
            resultado="Paciente não encotrado\n Verifique os dados na aba 'Ver Pacientes'";
            request.setAttribute("resultado", cpf);
            RequestDispatcher dispachante=getServletContext().getRequestDispatcher("/Login.jsp");
            dispachante.forward(request, response);
        
        }else {
        
           String nome=pacienteDAO.buscarPaciente(cpf);
            
            request.setAttribute("nome", nome);
            RequestDispatcher dispachante=getServletContext().getRequestDispatcher("/Marca_Consulta.jsp");
            dispachante.forward(request, response);
        }
        
        
        
        
        
        
        
        
        
        
    }

   
    
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nomePTriagem=request.getParameter("nomePaciente");
        
        if(nomePTriagem == null){
        
            RequestDispatcher dispachante=getServletContext().getRequestDispatcher("/Marca_Consulta.jsp");
            dispachante.forward(request, response);
        }else {
            PacienteDAO pacienteDAO=new PacienteDAO();
            String cpf=pacienteDAO.buscarPorNome(nomePTriagem);
            pacienteDAO.mudarStatusTriagem(cpf,"Triagem");           
            request.setAttribute("nomePTriagem", nomePTriagem);
            RequestDispatcher dispachante=getServletContext().getRequestDispatcher("/Triagem.jsp");
            dispachante.forward(request, response);
        }
        
        
        
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
