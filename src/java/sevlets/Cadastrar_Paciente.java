/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sevlets;

import conexaoBanco.ConexaoPostgres;
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
       
        
        
        
        
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        PreparedStatement pStatement;
        String sqlComando;
        String nome=request.getParameter("nomep");
        String endereco=request.getParameter("enderecop");
        
        String data_paciente=request.getParameter("data_nasp");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(data_paciente, formatter);
        java.sql.Date Datasql = java.sql.Date.valueOf(localDate);
        
        
        String cpf=request.getParameter("cpfp");
        String email=request.getParameter("emailp");
        String telefone=request.getParameter("telefonep");
        String convenio=request.getParameter("convenios");
        try {
            sqlComando="INSERT INTO pacientes(nome,endereco,data_paciente,cpf,email,telefone,convenio) VALUES(?,?,?,?,?,?,?)";
            pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
            pStatement.setString(1, nome);
            pStatement.setString(2, endereco);
            pStatement.setDate(3, Datasql);
            pStatement.setString(4, cpf);
            pStatement.setString(5, email);
            pStatement.setString(6, telefone);
            pStatement.setString(7, convenio);
            
            pStatement.executeUpdate();
            
            RequestDispatcher dispachante=getServletContext().getRequestDispatcher("/Login.jsp");
            dispachante.forward(request, response);
            
        } catch (Exception e) {
        }
        
        
        
        
        
        
        
    }

    
    
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
