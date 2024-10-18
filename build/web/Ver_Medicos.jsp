<%@page import="Classes.Medicos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.PacienteDAO"%>
<%@page import="DAO.MedicoDAO"%>
<%@page import="Classes.Convenios"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Pacientes</title>
        <link rel="stylesheet" href="Ver_Pacientes.css"/>
        
    </head>
    <body>
        
        <header>
            <h1>LISTA DE MEDICOS</h1>
        </header>
        <div class="containerCadastro">
             <h2>MEDICOS:</h2>'      
             <table border="1"> 
               <tr>
                   <td style="border: 2px">NOME</td>
                     <td style="border: 2px">CRM</td>
                     <td style="border: 2px">ESPECIALIDADE</td>
                     </tr>
                 <%
                     List<Medicos> crmBuscar = (List<Medicos>) request.getAttribute("listaMedicos");
                  if (crmBuscar != null) {    
                       for(Medicos listar : crmBuscar){
                %>     
                     <tr>
                     <td> <%= listar.getNome() %> </td>
                     <td><%= listar.getCrm() %></td>
                     <td><%= listar.getEspecialidade() %></td>
                     </tr>
                <%   
                        }
                   }else {
                %>
                <tr>
                    <td colspan="2">Nenhum Medico encontrado.</td>
                </tr>
                <% } %>
             </table>     
        </div> 
                
              
                     
          
    <center><form style="color:white;" action="Ver_Medicos" method="get">
                     
                     BUSCAR POR CPF:<br><input type="text" name="crmBuscar" size="20"><br>
                     <input type="submit" name="buscar" value="BUSCAR">
                     
                     
                 </form></center>
        
       
        
        
        
    <footer style=" height:150px; margin-top: 100px">
        <p style="color:white"><i>Clinica Gestão 1.0</i></p>
        <center><a href="https://github.com/tatetinho">Tatetinho</a></center>
        <center><img src="imagens/github_logo.png" ></center>
    </footer> 
        
    </body>
</html>






