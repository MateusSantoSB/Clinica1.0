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
        <link rel="stylesheet" type="text/css" href="Consulta_Triagem.css" >
    </head>
    
    
    
    <%
        String nome=(String)request.getAttribute("nomePaciente");
    %>
    <body> 
        
        <header>
            <h1 style="padding-top:20px;padding-bottom: 25px;margin-bottom: 30px;">TRIAGEM</h1>
        </header>
        
        <div class="containerCadastro">
           
         <h1><%=nome%></h1>
        <form action="Consulta_Triagem" method="post">
            RELATORIO INICIAL:
            <br><textarea name="relatorioPaciente" style="height: 200px" ></textarea><br>
            <label style="margin-top: 40px;">RISCO DO PACIENTE:</label><br>
            <input type="radio" name="risco" value="Verde" ><label style="color:green;">VERDE</label><br>
            <input type="radio" name="risco" value="Amarelo"><label style="color:yellow;">AMARELO</label><br>
            <input type="radio" name="risco" value="Vermelho"><label style="color:red;">VERMELHO</label><br>
            ESPECIALIDADE:
            <select name="especialidadeTriagem">
                <option>Selecione</option>
                <%
                EspecialidadesDAO especialidadesDAO=new EspecialidadesDAO();    
                List<String> listaEspecialidades=especialidadesDAO.listarEspecialidades();
                for(String listar:listaEspecialidades){
                %>
                <option value="<%=listar%>"><%=listar%> </option>
                <%
                    }
                %>
             </select>
             <input type="hidden" name="nomePacienteTriage" value="<%=nome%>">
            <input style="margin-top: 20px;" type="submit" name="risco" value="ENVIAR PARA CONSULTA">
            </form>  
           
        </div>
                
 
            
      
            
        
       <footer style=" height:150px; margin-top: 100px">
        <p style="color:white"><i>Clinica Gestão 1.0</i></p>
        <center><a href="https://github.com/tatetinho">Tatetinho</a></center>
        <center><img src="imagens/github_logo.png" ></center>
    
    </footer>     
            
            
            
    </body>
</html>

