
package sevlets;
 
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import conexaoBanco.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession; 


public class Verificar_Login extends HttpServlet {
    
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String sqlComando="SELECT * FROM usuarios WHERE login=? AND senha=? "; 
      String login=request.getParameter("usuario");
      String senha=request.getParameter("senha");
      String nomeUsuario; 
      String cpfUsuario;
      String funcaoUsuario;
      String especialidades="";
      String especialidadeEnfermeiro="";
      String crm="";
      String registro="";
      
      PreparedStatement pStatement;
     
   
      
      
      if (login != null && senha != null){
      try {
            
             pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);

             pStatement.setString(1, login);
             pStatement.setString(2, senha);
             
            
            ResultSet rs=pStatement.executeQuery();
            if(rs.next()){//retorna true ou false se tem alteração no banco
             
            nomeUsuario=rs.getString("nome");
            cpfUsuario=rs.getString("cpf");
            funcaoUsuario=rs.getString("funcao");
            
            
            
            if (funcaoUsuario.equals("Atendente")){
                  HttpSession session=request.getSession();
                        session.setAttribute("nomeUsuario", nomeUsuario);
                        session.setAttribute("cpfUsuario", cpfUsuario);
                 RequestDispatcher Despachante=getServletContext().getRequestDispatcher("/Login.jsp");
                Despachante.forward(request, response);
            }else if(funcaoUsuario.equals("Enfermeiro")){
                
                        HttpSession session=request.getSession();
                        
                        sqlComando="SELECT * FROM enfermeiros WHERE cpf=?";
                        
                        try {
                    pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
                    
                    pStatement.setString(1, cpfUsuario);
                    rs=pStatement.executeQuery();
                    
                    while(rs.next()){
                        especialidadeEnfermeiro=rs.getString("especialidade");
                        registro=rs.getString("registro");
                        
                        
                        
                    }
                    
                } catch (Exception e) {
                }
                            
                        
                        
                        
                        session.setAttribute("nomeUsuario", nomeUsuario);
                        session.setAttribute("cpfUsuario", cpfUsuario);
                        session.setAttribute("especialidades", especialidadeEnfermeiro);
                        session.setAttribute("registro", registro);
                        
                RequestDispatcher Despachante=getServletContext().getRequestDispatcher("/Triagem.jsp");
                Despachante.forward(request, response);
            
            }else if(funcaoUsuario.equals("Medico")){
                         HttpSession session=request.getSession();
                         
                         String sqlComando2="SELECT * FROM medicos WHERE cpf=?";
                        
                        try {
                                     pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando2);
                                     
                                     pStatement.setString(1, cpfUsuario);
                                     rs=pStatement.executeQuery();
                                     
                                     while(rs.next()){
                                   especialidades=rs.getString("especialidade");
                                   crm=rs.getString("crm");
                                   
                                     
                                     
                                     }
                              } catch (Exception e) {
                    
                    
                                 }
                            
                         
                         
                         
                        session.setAttribute("nomeUsuario", nomeUsuario);
                        session.setAttribute("cpfUsuario", cpfUsuario);
                        session.setAttribute("especialidades",especialidades );
                        session.setAttribute("crm", crm);
                        
                RequestDispatcher Despachante=getServletContext().getRequestDispatcher("/Consulta.jsp");
                Despachante.forward(request, response);
            }
                
           
           
            }else{
           
            RequestDispatcher Despachante=getServletContext().getRequestDispatcher("/index.html");
            Despachante.forward(request, response);
            
            }
            
             
             
        } catch (SQLException ex) {
            
            RequestDispatcher Despachante=getServletContext().getRequestDispatcher("/index.html");
             Despachante.forward(request, response);
            
            
        }
       
      }else{
             
             RequestDispatcher Despachante=getServletContext().getRequestDispatcher("/index.html");
             Despachante.forward(request, response);
      
      
      }
           
        






    }

    
}
