

<%@page import="DAO.EspecialidadesDAO"%>
<%@page import="DAO.MedicoDAO"%>
<%@page import="Classes.Convenios"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="Cadastra_Funcionarios/Cadastro_Enfermeiro.css"/>
        
    </head>
    <body>
        
        <header>
            <h1>CADASTRO DE PACIENTES</h1>
        </header>
        <div class="containerCadastro">
             <h2>PREENCHA OS DADOS DO PACIENTE</h2>
                     <form action='Cadastrar_Funcionario' method='post'>
                     Nome:<br><input type='text' name='nomee' size=20>
                     Cpf:<br><input type='text' name='cpfe' size=20><br>
                     Email:<br><input type='text' name='emaile' size=20><br>
                     login:<br><input type='text' name='logine' size=20>
                     senha:<br><input type='text' name='senhae' size=20><br>
                     Data Nascimento:<br><input type='date' name='data_nase' size=20><br>
                     Função:<br><input type='text' name='funcaoe' value='Enfermeiro' size=20 readonly>
                     ESPECIALIDADE:<br>
                     <select name='especialidadee' style="margin-top:10px;margin-bottom: 10px;">
                    <option value=''>Selecione</option>
                    <%
                        EspecialidadesDAO especialidadesDAO=new EspecialidadesDAO();
                        List<String> listaEspecialidade= especialidadesDAO.listarEspecialidades();
                        for (String especialidades : listaEspecialidade) {
                    %>
                    <option id="especialidadee" value="<%= especialidades %>"> <%= especialidades %></option><br>
                    <%
                        }
                    %>
                </select><br>
                     Registro:<br><input type='text' name='registroe' size=20><br>  
                     <input type='hidden' name='funcaoOculta' value='Enfermeiro'>
                     <input type='submit' value='cadastrar enfermeiro' style='margin-top:15px'>
                     </form>
        </div>
        
       
        
        
        
    <footer style=" height:150px; margin-top: 100px">
        <p style="color:white"><i>Clinica Gestão 1.0</i></p>
        <center><a href="https://github.com/tatetinho">Tatetinho</a></center>
        <center><img src="imagens/github_logo.png" ></center>
    </footer> 
        
    </body>
</html>
