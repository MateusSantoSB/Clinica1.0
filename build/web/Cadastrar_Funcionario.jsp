<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Funcionario</title>
        <link rel="stylesheet" type="text/css" href="Cadastrar_Funcionario.css" >
    </head>
    
    
    
    
    <body>
        <%
            String funcaoFormulario=
                    "<h2>SELECIONE A FUNÇÃO</h2><br>"+
                    "<form  action='Cadastrar_Funcionario.jsp' method='get' >"+
                   "<input type='radio'  name='funcao' value='Medico'>Medico<br>"+
                   " <br> <input type='radio'  name='funcao' value='Atendente'>Atendente<br>"+
                    "<br> <input type='radio'  name='funcao' value='Enfermeiro'>Enfermeira<br>"+
                    "<br> <input type='submit' value='    Continuar' style='padding-right: 20px '> "+
               " </form>";
                         
        %>
        
        
        
    
        
        <header>
            <h1 style="padding-top:20px;padding-bottom: 25px;margin-bottom: 30px;">CADASTRO DE USUARIOS</h1>
        </header>
        
        <div class="containerCadastro">
            
            <%
                
                String funcaostr=request.getParameter("funcao");
                
                
                
                if(funcaostr==null){
                    out.println(funcaoFormulario);
                
                
                }else if(funcaostr.equals("Medico")){
                  
                request.getRequestDispatcher("Cadastra_Funcionarios/Cadastro_Medico.jsp").forward(request, response);
                }else if(funcaostr.equals("Atendente")){
                    request.getRequestDispatcher("Cadastra_Funcionarios/Cadastro_Atendente.jsp").forward(request, response);
                }else if (funcaostr.equals("Enfermeiro")){
                   request.getRequestDispatcher("Cadastra_Funcionarios/Cadastro_Enfermeiro.jsp").forward(request, response);
                }

            %>
            
              
            
            
        </div>
            
       <footer style=" height:150px; margin-top: 100px">
        <p style="color:white"><i>Clinica Gestão 1.0</i></p>
        <center><a href="https://github.com/tatetinho">Tatetinho</a></center>
        <center><img src="imagens/github_logo.png" ></center>
    
    </footer>     
            
            
            
    </body>
</html>
