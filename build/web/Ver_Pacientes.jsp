<%@page import="Classes.Paciente"%>
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
            <h1>LISTA DE PACIENTES</h1>
        </header>
        <div class="containerCadastro">
             <h2>PACIENTES:</h2>
           
             
             
             
             <table border="1"> 
               <tr>
                   <td style="border: 2px">NOME</td>
                     <td style="border: 2px">CONVENIO</td>
                     <td style="border: 2px">CPF</td>
                     </tr>
                 <% 
                    List<Paciente> cpfBuscar = (List<Paciente>) request.getAttribute("listaPaciente");
                  if (cpfBuscar != null) {
                       for(Paciente listar : cpfBuscar){
                %>  
                     <tr>
                     <td> <%= listar.getNome() %> </td>
                     <td><%= listar.getConvenio() %></td>
                     <td><%= listar.getCpf() %></td>
                     </tr>
                <%   
                        }
                   }else {
                %>
                <tr>
                    <td colspan="2">Nenhum paciente encontrado.</td>
                </tr>
                <% } %>
             </table>
            
        </div> 
                
              
                     
          
    <center><form style="color:white;" action="Ver_Pacientes" method="get">
                     
                     BUSCAR POR CPF:<br><input type="text" name="cpfBuscar" size="20"><br>
                     <input type="submit" name="buscar" value="BUSCAR">
                     
                     
                 </form></center>
        
       
        
        
        
    <footer style=" height:150px; margin-top: 100px">
        <p style="color:white"><i>Clinica Gestão 1.0</i></p>
        <center><a href="https://github.com/tatetinho">Tatetinho</a></center>
        <center><img src="imagens/github_logo.png" ></center>
    </footer> 
        
    </body>
</html>






