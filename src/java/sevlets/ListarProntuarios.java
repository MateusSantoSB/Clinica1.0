/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sevlets;

import DAO.PacienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Classes.Paciente;
import javax.servlet.http.HttpSession;
/**
 *
 * @author mateu
 */
public class ListarProntuarios extends HttpServlet {

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
            out.println("<title>Servlet ListarProntuarios</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListarProntuarios at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        
        
        
        
        
        String cpf=request.getParameter("cpfPaciente");
        List<Paciente> dados= pacienteDAO.dadosPaciente(cpf);
        String nome="Nulo";
        String endereco="Nulo";
        String email="Nulo";
        String telefone="Nulo";
        String convenio="Nulo";
        
        String data=request.getParameter("data");
        String hora=request.getParameter("hora");
        String relatorio=request.getParameter("relatorio");
        
        String nome_medico=request.getParameter("nome_medico");
        String crm=request.getParameter("crm");
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
        request.setAttribute("crm", crm);
        request.setAttribute("nome_medico", nome_medico);
        request.setAttribute("especialidade", especialidade);
        RequestDispatcher dispachante=getServletContext().getRequestDispatcher("/Prontuario.jsp");
        dispachante.forward(request, response);  
    }

   
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
