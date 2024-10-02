

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Inicial</title>
        <link rel="stylesheet" type="text/css" href="Login.css">
        
        
        <%
        
        String nome_usuario=(String) session.getAttribute("nomeUsuario"); 
        
        
        if(nome_usuario==null){
         response.sendRedirect("/index.html");
            
        }else{
            nome_usuario=nome_usuario.toUpperCase();
        }
      
        
        


        %>
        
    </head>
    <body>
        <header>
            <h1 style="padding-top: 30px;">CLINICA GESTOR 1.0</h1> 
            <% 
            out.println("<p style='color:white'><i> BEM VINDO " +nome_usuario+ "</i></p"); 
          %> 
        </header>
        
        <div class="botoes">
            <a href="Cadastrar_Paciente.jsp" target="_blank"> 
            <button class="botao">CADASTRAR PACIENTE</button>
            </a>
            <a href="Marca_Consulta.jsp" target="_blank">
                    <button class="botao">MARCAR CONSULTA</button>
                    </a>    
                  <a href="Ver_Pacientes.jsp" target="_blank">
                  <button class="botao">VER PACIENTES</button>
                    </a>    
                  <a href="Cadastrar_Convenios.jsp" target="_blank">
                            <button class="botao">CADASTRAR CONVENIOS</button>
                           </a>
                                <a href="Ver_Medicos.jsp" target="_blank"> 
                                    <button class="botao">VER MEDICOS</button> 
                                </a>
                              
                               <a href="Cadastrar_Especialidade.jsp" target="_blank"> 
                                  <button class="botao">CADASTRAR ESPECIALIDADE</button>
                                 </a>
        </div>
        
    <center> <a href="Cadastrar_Funcionario.jsp" target="_blank" style="">CADASTRAR FUNCIONARIO</a></center>
       <footer>
        
        <p style="color:white"><i>Clinica Gestão 1.0</i></p>
        <center><a href="https://github.com/tatetinho">Tatetinho</a></center>
       <center> <img src="imagens/github_logo.png" ></center>
    
    </footer>
    </body>
    
    
    
</html>
