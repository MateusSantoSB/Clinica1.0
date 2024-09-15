
package sevlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import conexaoBanco.*;
import static java.lang.System.out;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

public class Cadastrar_Funcionario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Cadastrar_Funcionario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Cadastrar_Funcionario at " + request.getContextPath() + "</h1>");
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
        
        
        String sqlcomando="";
        PreparedStatement pStatment;
        
        
        
        String funcaostr=request.getParameter("funcaoOculta");
        if(funcaostr==null){
            System.out.println("erro");
            RequestDispatcher Despachante=getServletContext().getRequestDispatcher("/Login.jsp");
            Despachante.forward(request, response);
            return;
        }else{
           
        
        
        
        
        
       
        if(funcaostr.equals("Medico")){
           
           String nome=request.getParameter("nomem");
           String cpf=request.getParameter("cpfm");
           String email=request.getParameter("emailm");
           String login=request.getParameter("loginm");
           String senha=request.getParameter("senham");
           String data_nas=request.getParameter("data_nasm");
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
           LocalDate localDate = LocalDate.parse(data_nas, formatter);
           java.sql.Date Datasql = java.sql.Date.valueOf(localDate);
           String funcao=request.getParameter("funcaom");
           String especialidade=request.getParameter("especialidadem");
           String crm=request.getParameter("crmm");
           
sqlcomando="INSERT INTO medicos (nome,cpf,email,login,senha,data_nas,funcao,especialidade,crm)VALUES(?,?,?,?,?,?,?,?,?)";
           
            try {
                
                pStatment=ConexaoPostgres.getConexao().prepareStatement(sqlcomando);
                pStatment.setString(1, nome);
                pStatment.setString(2, cpf);
                pStatment.setString(3, email); 
                pStatment.setString(4, login);
                pStatment.setString(5, senha);
                pStatment.setDate(6, Datasql);
                pStatment.setString(7, funcao);
                pStatment.setString(8, especialidade);
                pStatment.setString(9, crm);
                 
             pStatment.executeUpdate();
             
             
             RequestDispatcher dispachante=getServletContext().getRequestDispatcher("/Cadastrar_Funcionario.jsp");
             dispachante.forward(request, response);
             
            } catch (SQLException ex) {
               
            }
           
           
          
        }else if(funcaostr.equals("Atendente")){
           String nome=request.getParameter("nomea");
           String cpf=request.getParameter("cpfa");
           String email=request.getParameter("emaila");
           String login=request.getParameter("logina");
           String senha=request.getParameter("senhaa");
           String data_nasa=request.getParameter("data_nasa");
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
           LocalDate localDate = LocalDate.parse(data_nasa, formatter);
           java.sql.Date Datasql = java.sql.Date.valueOf(localDate);
           String funcao=request.getParameter("funcaoa");
           
        
        sqlcomando="INSERT INTO usuarios (nome,cpf,email,login,senha,data_nas,funcao)VALUES(?,?,?,?,?,?,?)";
        PreparedStatement pStatementa;
        
            try {
                pStatementa=ConexaoPostgres.getConexao().prepareStatement(sqlcomando);
                
                pStatementa.setString(1, nome);
                pStatementa.setString(2, cpf);
                pStatementa.setString(3, email);
                pStatementa.setString(4, login);
                pStatementa.setString(5, senha);
                pStatementa.setDate(6, Datasql);
                pStatementa.setString(7, funcao);
                
                pStatementa.executeUpdate();
                RequestDispatcher dispachante=getServletContext().getRequestDispatcher("/Cadastrar_Funcionario.jsp");
                dispachante.forward(request, response);
            } catch (SQLException ex) {
                
            }
        
        
        
        
        }else if(funcaostr.equals("Enfermeiro")){
        
           String nome=request.getParameter("nomee");
           String cpf=request.getParameter("cpfe");
           String email=request.getParameter("emaile");
           String login=request.getParameter("logine");
           String senha=request.getParameter("senhae");
           String data_nas=request.getParameter("data_nase");
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
           LocalDate localDate = LocalDate.parse(data_nas, formatter);
           java.sql.Date Datasqle = java.sql.Date.valueOf(localDate);
           String funcao=request.getParameter("funcaoe");
           String especialidade=request.getParameter("especialidadee");
           String crm=request.getParameter("crme");
            

           PreparedStatement pStatementE;
           String slqcomando="INSERT INTO medicos(nome,cpf,email,login,senha,data_nas,funcao,especialidade,crm) VALUES(?,?,?,?,?,?,?,?,?)";
            try {
                pStatementE=ConexaoPostgres.getConexao().prepareStatement(slqcomando);
                
                
                pStatementE.setString(1, nome);
                pStatementE.setString(2, cpf);
                pStatementE.setString(3, email);
                pStatementE.setString(4, login);
                pStatementE.setString(5, senha);
                pStatementE.setDate(6, Datasqle);
                pStatementE.setString(7, funcao);
                pStatementE.setString(8, especialidade);
                pStatementE.setString(9, crm);
                
                
                pStatementE.executeUpdate();
                
                RequestDispatcher dispachante=getServletContext().getRequestDispatcher("/Cadastrar_Funcionario.jsp");
                dispachante.forward(request, response);
                
                
            } catch (Exception e) {
                
            }
     
            
        
        
        
        }
        
         
        
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

   

}
