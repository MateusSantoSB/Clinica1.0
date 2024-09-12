/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sevlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import conexaoBanco.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;


public class Verificar_Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String sqlComando="SELECT * FROM usuarios WHERE login=? AND senha=? ";
      String login=request.getParameter("usuario");
      String senha=request.getParameter("senha");
      String resultado; 
      PreparedStatement pStatement;
     
      
      if (login != null && senha != null){
      try {
            
             pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);

             pStatement.setString(1, login);
             pStatement.setString(2, senha);
             
            
            ResultSet rs=pStatement.executeQuery();
            if(rs.next()){
             
            resultado=rs.getString("nome");
            request.setAttribute("resultado",(resultado));
            
            RequestDispatcher Despachante=getServletContext().getRequestDispatcher("/Login.jsp");
            Despachante.forward(request, response);
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
