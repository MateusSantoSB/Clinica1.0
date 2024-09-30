
package sevlets;

import Classes.Atendentes;
import Classes.Enfermeiros;
import Classes.Medicos;
import DAO.AtendentesDAO;
import DAO.EnfermeirosDAO;
import DAO.MedicoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

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
           String funcao=request.getParameter("funcaom");
           String especialidade=request.getParameter("especialidadem");
           String crm=request.getParameter("crmm");
           
  
           Medicos medicos=new Medicos(nome,cpf,email,login,senha,data_nas,funcao,especialidade,crm);
           MedicoDAO medicoDAO=new MedicoDAO();
           medicoDAO.cadastrarMedico(medicos);
             
             RequestDispatcher dispachante=getServletContext().getRequestDispatcher("/Cadastrar_Funcionario.jsp");
             dispachante.forward(request, response);
           
           
          
        }else if(funcaostr.equals("Atendente")){
           String nome=request.getParameter("nomea");
           String cpf=request.getParameter("cpfa");
           String email=request.getParameter("emaila");
           String login=request.getParameter("logina");
           String senha=request.getParameter("senhaa");
           String data_nas=request.getParameter("data_nasa");  
           String funcao=request.getParameter("funcaoa");
           
        
           Atendentes atendentes=new Atendentes(nome,cpf,email,login,senha,data_nas,funcao);
           AtendentesDAO atendentesDAO=new AtendentesDAO();
           atendentesDAO.cadastrarAtendente(atendentes);
        
          
                RequestDispatcher dispachante=getServletContext().getRequestDispatcher("/Cadastrar_Funcionario.jsp");
                dispachante.forward(request, response);
         
        
        
        
        }else if(funcaostr.equals("Enfermeiro")){
        
           String nome=request.getParameter("nomee");
           String cpf=request.getParameter("cpfe");
           String email=request.getParameter("emaile");
           String login=request.getParameter("logine");
           String senha=request.getParameter("senhae");
           String data_nas=request.getParameter("data_nase");
           String funcao=request.getParameter("funcaoe");
           String especialidade=request.getParameter("especialidadee");
           String registro=request.getParameter("registroe");
            

           Enfermeiros enfermeiros=new Enfermeiros(nome,cpf,email,login,senha,data_nas,funcao,especialidade,registro);
           EnfermeirosDAO enfermeirosDAO=new EnfermeirosDAO();
           enfermeirosDAO.cadastrarEnfermeiros(enfermeiros);
           
           
           
                
                RequestDispatcher dispachante=getServletContext().getRequestDispatcher("/Cadastrar_Funcionario.jsp");
                dispachante.forward(request, response);
                
                
           
     
            
        
        
        
        }
        
         
        
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

   

}
