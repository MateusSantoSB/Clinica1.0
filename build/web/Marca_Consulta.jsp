<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Marcar Consulta</title>
        <link rel="stylesheet" type="text/css" href="Marcar_Consulta.css" >
    </head>
    
    
    
    
    <body> 
        
        <header>
            <h1 style="padding-top:20px;padding-bottom: 25px;margin-bottom: 30px;">MARCAR CONSULTA</h1>
        </header>
        
        <div class="containerCadastro">
            <h2> BUSCAR PACIENTE</h2>
            
           
            <form action="Marcar_Consulta" method="get">
INSIRA O CPF DO PACIENTE:<br><input type="text" name="cpf" size="30" style="margin-bottom: 10px;"><br> 
            <center><input type="submit" name="buscarCpf" value="BUSCAR" style="padding-left:30px; padding-right: 30px;"></center> 
            </form>
            
            <br>
           
        </div>
                <div class="containerCadastro">
                    
            <%
            String nomePaciente=(String)request.getAttribute("nome");
            %>
            <h2 style="height: 40px"> <%=nomePaciente%> </h2>
            <form action="Marcar_Consulta" method="post">
                <input type="hidden" name="nomePaciente" value="<%= nomePaciente%>">
                <center><input  type="submit" name="botaoTriagem" value="ENVIAR PARA TRIAGEM" style="margin-top: 30px;"><center>
            </form>
                </div>
        
 
            
      
            
        
       <footer style=" height:150px; margin-top: 100px">
        <p style="color:white"><i>Clinica Gestão 1.0</i></p>
        <center><a href="https://github.com/tatetinho">Tatetinho</a></center>
        <center><img src="imagens/github_logo.png" ></center>
    
    </footer>     
            
            
            
    </body>
</html>
