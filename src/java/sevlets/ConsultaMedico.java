/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sevlets;

import Classes.Prontuario;
import DAO.PacienteDAO;
import DAO.ProntuarioDAO;
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
public class ConsultaMedico extends HttpServlet {

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
            out.println("<title>Servlet ConsultaMedico</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConsultaMedico at " + request.getContextPath() + "</h1>");
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
        String botao=request.getParameter("botao");
        String nome=request.getParameter("nomePaciente");
        String cpf=request.getParameter("cpfPaciente");
        String url="";
        RequestDispatcher dispachante;
        
        ProntuarioDAO prontuarioDAO=new ProntuarioDAO();
    
        
        if(botao.equals("1")){
        request.setAttribute("nome", nome);
        request.setAttribute("cpf", cpf);
      
        dispachante=getServletContext().getRequestDispatcher("/listaProntuarios.jsp"); 
        dispachante.forward(request, response);
        }else if (botao.equals("2")){
        
        request.setAttribute("nome", nome);
        request.setAttribute("cpf", cpf);
       
        dispachante=getServletContext().getRequestDispatcher("/listaAnamnese.jsp"); 
        dispachante.forward(request, response);
        }
        
        
        
        
        
        
        
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
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");

        
        String relatorio=request.getParameter("novoProntuarioPaciente");
        String cpf=request.getParameter("cpfPaciente");
        String especialidade=request.getParameter("especialidade");
        String nome_medico=request.getParameter("nome_medico");
        String crm=request.getParameter("crm");
        
        
        
        
        
       if (relatorio==null || cpf==null || relatorio.isEmpty()){
       
       response.sendRedirect("/Consulta.jsp");
       }         
                
        Prontuario prontuario=new Prontuario(relatorio,cpf,especialidade,nome_medico,crm);
        ProntuarioDAO prontuarioDAO=new ProntuarioDAO();
        prontuarioDAO.criarProntuario(prontuario);
        
        PacienteDAO pacienteDAO=new PacienteDAO();
        pacienteDAO.finalizarConsulta(cpf, "NULL");
        
        
        
        
        RequestDispatcher dispachante=getServletContext().getRequestDispatcher("/Consulta.jsp");
        dispachante.forward(request, response);
        
        
    }
    

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
