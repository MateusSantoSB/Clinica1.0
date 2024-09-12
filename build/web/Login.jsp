<%-- 
    Document   : Login_certo
    Created on : 7 de set. de 2024, 20:40:38
    Author     : mateus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="Login.css">
        
        
        <%
        String nome_usuario=(String) request.getAttribute("resultado"); 
        
        
        if(nome_usuario==null){
          nome_usuario="ADMINISTRADOR";
            
        }else{
            nome_usuario=nome_usuario.toUpperCase();
        }
      
        
        


        %>
        
    </head>
    <body>
        <header>
            <h1 style="padding-top: 30px;">CLINICA SAUDE MILITAR</h1> 
            <% 
            out.println("<p> BEM VINDO " +nome_usuario+ "</p"); 
          %> 
        </header>
        
        <div class="botoes">
            <a href="Cadastrar_Paciente.jsp" target="_blank"> 
            <button class="botao">CADASTRAR PACIENTE</button>
            </a>
                  <button class="botao">MARCAR CONSULTA</button>
                        <button class="botao">VER PACIENTES</button>
                            <button class="botao">CADASTRAR PLANO</button>
                               <button class="botao">VER PLANOS</button> 
                                    <button class="botao">VER PLANOS</button>
                                         
        </div>
        
       <center> <a href="Cadastrar_Funcionario.jsp" target="_blank" style="">CADASTRAR FUNCIONARIO</a></center>
        
        
        
        
        
        
        
        
        
        
        
    </body>
</html>
