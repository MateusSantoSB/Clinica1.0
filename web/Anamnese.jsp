

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prontuario</title>
        <%
            String nome=(String)request.getAttribute("nome");
            String cpf=(String)request.getAttribute("cpf");
            String hora=(String)request.getAttribute("hora");
            String data=(String)request.getAttribute("data");
            String relatorio=(String)request.getAttribute("relatorio");
            String endereco=(String)request.getAttribute("endereco");
            String email=(String)request.getAttribute("email");
            String telefone=(String)request.getAttribute("telefone");
            String convenio=(String)request.getAttribute("convenio");
            String registro=(String)request.getParameter("registro");
            String nome_enfermeiro=(String)request.getParameter("nome_enfermeiro");
            String especialidade=(String) request.getParameter("especialidade");
        %>
        <link rel="stylesheet" href="Anamnese.css"/>
        
        
    </head>
    <body>
        <h3>Hospital São Mateus</h3>
        <h4>SRES qd. 2 (Ae), Brasília, DF, 70648-010 </h4>
        <h1>ANAMNESE TRIAGEM</h1>
        
        <div class="dados">
         <p>Nome Paciente: <%=nome %></p>   
          <p>Cpf: <%=cpf %></p>   
           <p>Endereço: <%=endereco %></p>
            <p>Email: <%=email %></p>
             <p>Telefone: <%=telefone %></p>
              <p>Convenio: <%=convenio %></p>
        </div>
        
        
        <div class="relatorio">
            <p>Data: <%=data%></p>
            <p>Hora: <%=hora%></p>
            <p>Enfermeiro:<%=nome_enfermeiro %></p>
            <p>Especialidade:<%=especialidade%></p>
            <p>Registro:<%=registro%></p>
            
            <br>
            <p><%=relatorio%></p>
            
            
        </div>
        
        
        
        
        
        
    </body>
</html>
