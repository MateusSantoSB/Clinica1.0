/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sevlets;

import Classes.Paciente;
import DAO.PacienteDAO;
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
public class ListarAnamnese extends HttpServlet {

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
            out.println("<title>Servlet ListarAnamnese</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListarAnamnese at " + request.getContextPath() + "</h1>");
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
       
         PacienteDAO pacienteDAO=new PacienteDAO();
      
        
        String cpf=request.getParameter("cpfPaciente");
        List<Paciente> dados= pacienteDAO.dadosPaciente(cpf);
        String nome="";
        String endereco="";
        String email="";
        String telefone="";
        String convenio="";
        
        String data=request.getParameter("data");
        String hora=request.getParameter("hora");
        String relatorio=request.getParameter("relatorio");
        
        String nome_enfermeiro=request.getParameter("nome_enfermeiro");
        String registro=request.getParameter("registro");
        String especialidade=request.getParameter("especialidade");
        
        for(Paciente listar:dados){
        nome=listar.getNome();
        endereco=listar.getEndereco();
        email=listar.getEmail();
        telefone=listar.getTelefone();
        convenio=listar.getConvenio(); 
    }
        
        
        
        
        request.setAttribute("nome",nome);
        request.setAttribute("cpf",cpf);
        request.setAttribute("endereco",endereco);
        request.setAttribute("email",email);
        request.setAttribute("telefone",telefone);
        request.setAttribute("convenio",convenio);
        request.setAttribute("data",data);
        request.setAttribute("hora",hora);
        request.setAttribute("relatorio",relatorio);
        request.setAttribute("registro", registro);
        request.setAttribute("nome_enfermeiro", nome_enfermeiro);
        request.setAttribute("especialidade", especialidade);
        RequestDispatcher dispachante=getServletContext().getRequestDispatcher("/Anamnese.jsp");
        dispachante.forward(request, response);  
        
        
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
