<%@page import="Classes.Especialidades"%>
<%@page import="DAO.EspecialidadesDAO"%>
<%@page import="DAO.PacienteDAO"%>
<%@page import="Classes.Paciente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Marcar Consulta</title>
        <link rel="stylesheet" type="text/css" href="ConsultaMedico.css" >
    </head>
    
    
    
    <%
        String nome=(String)request.getAttribute("nomePacienteMedico");
        String cpf=(String)request.getAttribute("cpfPacienteMedico");
        
        String nome_usuario=(String) session.getAttribute("nomeUsuario"); 
        String especialidadeM=(String) session.getAttribute("especialidades");
        String crm=(String) session.getAttribute("crm");
        
        if(nome_usuario==null){
         response.sendRedirect("/index.html");
            
        }else{
            nome_usuario=nome_usuario.toUpperCase();
        }



    %>
    <header>
            <h1 style="padding-top:20px;padding-bottom: 25px;margin-bottom: 30px;">CONSULTA</h1>
        </header>
    <body> 
        
        
        
       
        <div class="containerCadastro">
           
         <h1><%=nome%></h1><br>
         <p style="margin: 0; padding-bottom: 30px;"><%=cpf%></p>
         <form id="lateral" action="ConsultaMedico" method="get">
             <input type="submit" name="buscar" value="Ver Prontuarios" style="margin: 0px;"> 
             <input type="hidden" name="botao" value="1">
             <input type="hidden" name="nomePaciente" value="<%=nome%>">
             <input type="hidden" name="cpfPaciente" value="<%=cpf%>">
         </form>
         <form id="lateral" action="ConsultaMedico" method="get">
              <input type="submit" name="buscar" value="Ver Anamneses" style="margin: 0px;">
              <input type="hidden" name="botao" value="2">
              <input type="hidden" name="nomePaciente" value="<%=nome%>">
              <input type="hidden" name="cpfPaciente" value="<%=cpf%>">
         </form>
         
         
        <form action="ConsultaMedico" method="post">
            NOVO PRONTUARIO:
            <br><textarea name="novoProntuarioPaciente" style="height: 200px" ></textarea><br>
            <input type="hidden" name="cpfPaciente" value="<%=cpf%>">
            <input type="hidden" name="especialidade" value="<%=especialidadeM %>">
            <input type="hidden" name="nome_medico" value="<%=nome_usuario %>">
            <input type="hidden" name="crm" value="<%=crm %>">
            <input style="margin-top: 20px;" type="submit" name="finalizarConsulta" value="FINALIZAR CONSULTA">
            </form>  
        
        
    
        </div>
        
       
        
                
 
            
      
            
        
          
            
            
            
    </body>
    <footer style=" height:150px; margin-top: 100px">
        <p style="color:white"><i>Clinica Gestão 1.0</i></p>
        <center><a href="https://github.com/tatetinho">Tatetinho</a></center>
        <center><img src="imagens/github_logo.png" ></center>
    
    </footer>  
</html>

