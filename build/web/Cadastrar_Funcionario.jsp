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
                    "<form  action='' method='get'>"+
                   "<input type='radio'  name='funcao' value='Medico'>Medico<br>"+
                   " <br> <input type='radio'  name='funcao' value='Atendente'>Atendente<br>"+
                    "<br> <input type='radio'  name='funcao' value='Enfermeira'>Enfermeira<br>"+
                    "<br> <input type='submit' value='    Continuar' style='padding-right: 20px '> "+
               " </form>";
                  
             String formularioMedico=
                     "<form action='Cadastrar_Funcionario.jsp' method='get'>"+
                     "Nome:<br><input type='text' name='nome' size=20><br>"+
                     "Cpf:<br><input type='text' name='cpf' size=20>"+
                     "Email:<br><input type='text' name='email' size=20>"+
                     "Login:<br><input type='text' name='login' size=20>"+
                     "Senha:<br><input type='text' name='senha' size=20><br>"+
                     "Data Nascimento:<br><input type='text' name='data_nas' size=20>"+
                     "Funcao:<br><input type='text' name='funcao' size=20>"+
                     "Especialidade:<br><input type='text' name='especialidade' size=20>"+
                     "CRM:<br><input type='text' name='crm' size=20><br>"+
                     "<input type='submit' value'cadastrar' style='margin-top:15px'>"+
                     "</form>"; 
               
                    
                    
        
        
        
        
        %>
        
        
        
        
        
        <header>
            <h1 style="padding-top:20px;padding-bottom: 25px;margin-bottom: 30px;">Cadastrar Funcionario</h1>
        </header>
        
        <div class="containerCadastro">
            <h1>Cadastro</h1><br>
            <%
                String funcaostr=request.getParameter("funcao");
                if(funcaostr==null){
                    out.println(funcaoFormulario);
                
                
                }else if(funcaostr.equals("Medico")){
                   out.println(formularioMedico);
                
                
                
                }
            
            
            
            
            
            
            
            
            
            
            %>
            
              
            
            
        </div>
    </body>
</html>
