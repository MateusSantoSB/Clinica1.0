<%@page import="DAO.ProntuarioDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Classes.Prontuario"%>
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
        <link rel="stylesheet" type="text/css" href="ListasPacientes.css" >
    </head>
    
    
    
    <%
        String nome=(String)request.getAttribute("nome");
        String cpf=(String)request.getAttribute("cpf");
        


        String nome_medico=(String) session.getAttribute("nomeUsuario"); 
        String crm=(String)session.getAttribute("crm");
        String especialidade=(String)session.getAttribute("especialidade");
        
        
        if(nome_medico==null){
         response.sendRedirect("/index.html");
            
        }else{
            nome_medico=nome_medico.toUpperCase();
        }



    %>

    <header>
            <h1 style="padding-top:20px;padding-bottom: 25px;margin-bottom: 30px;"><%=nome%></h1>
        </header>
    <body> 

        
        
        
       
        <div class="containerCadastro">
          
            <h2>Prontuarios</h2>
            
            
            <table border="1">
                <td>Cpf</td>
                <td>DATA</td>
                <td>HORA</td>
                <br>
                <tr>
         <%
        List<Prontuario> listaProntuarios=new ArrayList<>();
        ProntuarioDAO prontuarioDAO=new ProntuarioDAO();
         listaProntuarios=prontuarioDAO.listarProntuarios(cpf);
        for(Prontuario listar:listaProntuarios){
         
         %>
        
          <form action="ListarProntuarios" method="post">
                    <td><%=listar.getCpf_paciente() %> </td>
                    <td><%=listar.getData() %>  </td>
                    <td><%=listar.getHora() %>  </td>
                    <input type="hidden" name="cpfPaciente" value="<%=listar.getCpf_paciente() %>">
                    <input type="hidden" name="data" value="<%=listar.getData() %>">
                    <input type="hidden" name="hora" value="<%=listar.getHora() %>">
                    <input type="hidden" name="relatorio" value="<%=listar.getRelatorio()%>">
                    <input type="hidden" name="nome_medico" value="<%=listar.getNome_medico() %>">
                    <input type="hidden" name="crm" value="<%=listar.getCrm() %>">
                    <input type="hidden" name="especialidade" value="<%=listar.getEspecialidade()   %>">
                    <td><input type="submit" name="consultaTriagem" value="Baixar" style="text-align: right;"></td>
                    </form>
                </tr>
         
         
    <%
    
     }
    %>
            </table>
        </div>
       
        
                
 
            
      
            
        
          
            
            
            
    </body>
     <footer style=" height:150px; margin-top: 100px">
        <p style="color:white"><i>Clinica Gestão 1.0</i></p>
        <center><a href="https://github.com/tatetinho">Tatetinho</a></center>
        <center><img src="imagens/github_logo.png" ></center>
    
    </footer> 
</html>

