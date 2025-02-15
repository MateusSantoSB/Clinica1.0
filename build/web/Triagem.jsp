<%@page import="DAO.PacienteDAO"%>
<%@page import="Classes.Paciente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Marcar Consulta</title>
        <link rel="stylesheet" type="text/css" href="Triagem.css" >
    </head>
    <%
        String nome_usuario=(String) session.getAttribute("nomeUsuario"); 
        
        
        if(nome_usuario==null){
         response.sendRedirect("/index.html");
            
        }else{
            nome_usuario=nome_usuario.toUpperCase();
        }

    %>
    
    
    
    <body> 
        
        <header>
            <h1 style="padding-top:20px;margin-top:0;">TRIAGEM</h1>
            <p>Bem vindo <%=nome_usuario %></p>
        </header>
        
        <div class="containerCadastro">
            <table border="1">
                <tr id="tituloTabela">
                    <td><h1>NOME PACIENTES</h1></td>
                    <td></td>
                </tr>
                <br>
                <tr>
                    <%
                    PacienteDAO pacienteDAO=new PacienteDAO();
                    List<Paciente> listaPacientes=pacienteDAO.listarPacientesTriagem();
                   
                    
                    for(Paciente listar: listaPacientes){
                    %>
                <form action="Triagem" method="get">
                    <td > <%=listar.getNome()%>  </td>
                    <td><input type="submit" name="consultaTriagem" value="Consultar" style="text-align: right;"></td>
                    <input style="margin-left:20px;" type="hidden" name="nomePacienteTriagem" value="<%=listar.getNome()%>">
                    </form>
                </tr>
                <%
                    }
                %>
                
                
                
                
            </table>
           
        </div>
                
 
            
      
            
        
       <footer style=" height:150px; margin-top: 100px">
        <p style="color:white"><i>Clinica Gestão 1.0</i></p>
        <center><a href="https://github.com/tatetinho">Tatetinho</a></center>
        <center><img src="imagens/github_logo.png" ></center>
    
    </footer>     
            
            
            
    </body>
</html>
