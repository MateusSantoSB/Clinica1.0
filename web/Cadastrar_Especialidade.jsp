<%-- 
    Document   : Cadastrar_Especialidade
    Created on : 24 de set. de 2024, 23:38:16
    Author     : mateu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Especialidade</title>
        <link rel="stylesheet" href="Cadastrar_Especialidade.css"/>
    </head>
    <body>
       <header>
            <h1>CADASTRO DE ESPECIALIDADES</h1>
        </header>
        <div class="containerCadastro">
             <h2>PREENCHA OS DADOS DA ESPECIALIDADE</h2>
                     <form action='Cadastrar_Especialidade' method='post'>
                         Nome:<br><input type="text" name="nomees" size="20" ><br>
                         Descrição:<br><input type="text" name="descricaoes" size="20" ><br>
                         <input type="submit" value="Cadastrar Nova Especialidade" size="20" style="margin-top:30px "><br>
                     </form>
        </div>
        
       
        
        
        
    <footer style=" height:150px; margin-top: 100px">
        <p style="color:white"><i>Clinica Gestão 1.0</i></p>
        <center><a href="https://github.com/tatetinho">Tatetinho</a></center>
        <center><img src="imagens/github_logo.png" ></center>
    </footer> 
    </body>
</html>
