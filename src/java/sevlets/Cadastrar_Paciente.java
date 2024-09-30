
package sevlets;

import Classes.Paciente;
import DAO.ConveniosDAO;
import DAO.PacienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;

public class Cadastrar_Paciente extends HttpServlet {

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
            out.println("<title>Servlet Cadastrar_Paciente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Cadastrar_Paciente at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        
        
        
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
   
        
        String nome=request.getParameter("nomep");
        String endereco=request.getParameter("enderecop");
        String data_paciente=request.getParameter("data_nasp");
        String cpf=request.getParameter("cpfp");
        String email=request.getParameter("emailp");
        String telefone=request.getParameter("telefonep");
        String convenio=request.getParameter("convenios");
        String status="Atendimento";
            
            Paciente paciente=new Paciente(nome,endereco,data_paciente,cpf,email,telefone,convenio,status);
            PacienteDAO pacientesS=new PacienteDAO();
            pacientesS.cadastrarPaciente(paciente);
            
           
            
            RequestDispatcher dispachante=getServletContext().getRequestDispatcher("/Login.jsp");
            dispachante.forward(request, response);
            
        
        
        
        
        
        
        
        
    }

    
    
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
