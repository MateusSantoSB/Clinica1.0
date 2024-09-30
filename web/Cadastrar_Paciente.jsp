<%-- 
    Document   : Cadastrar_Usuario
    Created on : 10 de set. de 2024, 12:41:59
    Author     : mateu
--%>

<%@page import="DAO.ConveniosDAO"%>
<%@page import="Classes.Convenios"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Paciente</title>
        <link rel="stylesheet" href="Cadastrar_Paciente.css"/>
        
    </head>
    <body>
        
        <header>
            <h1>CADASTRO DE PACIENTES</h1>
        </header>
        <div class="containerCadastro">
             <h2>PREENCHA OS DADOS DO PACIENTE</h2>
                     <form action='Cadastrar_Paciente' method='post'>
                     Nome:<br><input type='text' name='nomep' size=20>
                     Endereço:<br><input type='text' name='enderecop' size=20><br>
                     Data Nascimento:<br><input type='date' name='data_nasp' size=20><br>
                     Cpf:<br><input type='text' name='cpfp' size=20>
                     Email:<br><input type='text' name='emailp' size=20><br>
                     Convenio:<br>
                     <select name='convenios' style="margin-top:10px;margin-bottom: 10px;">
                    <option value=''>Selecione</option>
                    <%
                        ConveniosDAO conveniosDAO=new ConveniosDAO();
                        List<String> listaConvenios = conveniosDAO.listarConvenios();
                        for (String convenios : listaConvenios) {
                    %>
                    <option id="conveniosp" value="<%= convenios %>"> <%= convenios %></option><br>
                    <%
                        }
                    %>
                </select><br>
                     Telefone:<br><input type='text' name='telefonep' size=20>
                     <input type='submit' value='Cadastrar Paciente' style='margin-top:15px'>
                     </form>
        </div>
        
       
        
        
        
    <footer style=" height:150px; margin-top: 100px">
        <p style="color:white"><i>Clinica Gestão 1.0</i></p>
        <center><a href="https://github.com/tatetinho">Tatetinho</a></center>
        <center><img src="imagens/github_logo.png" ></center>
    </footer> 
        
    </body>
</html>
