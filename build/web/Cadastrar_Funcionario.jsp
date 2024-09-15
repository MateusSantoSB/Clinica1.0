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
                    "<form  action='Cadastrar_Funcionario.jsp' method='get'>"+
                   "<input type='radio'  name='funcao' value='Medico'>Medico<br>"+
                   " <br> <input type='radio'  name='funcao' value='Atendente'>Atendente<br>"+
                    "<br> <input type='radio'  name='funcao' value='Enfermeiro'>Enfermeira<br>"+
                    "<br> <input type='submit' value='    Continuar' style='padding-right: 20px '> "+
               " </form>";
                  
             String formularioMedico=
                     "<form action='Cadastrar_Funcionario' method='post'>"+
                     "Nome:<br><input type='text' name='nomem' size=20><br>"+
                     "Cpf:<br><input type='text' name='cpfm' size=20>"+
                     "Email:<br><input type='text' name='emailm' size=20>"+
                     "Login:<br><input type='text' name='loginm' size=20>"+
                     "Senha:<br><input type='text' name='senham' size=20><br>"+
                     "Data Nascimento:<br><input type='date' name='data_nasm' size=20><br>"+
                     "Função:<br><input type='text' name='funcaom' value='Medico' size=20 readonly>"+
                     "Especialidade:<br><input type='text' name='especialidadem' size=20>"+
                     "CRM:<br><input type='text' name='crmm' size=20><br>"+
                     "<input type='hidden' name='funcaoOculta' value='Medico'>"+
                     "<input type='submit' value='cadastrar' style='margin-top:15px'>"+
                     "</form>"; 
               
             String formularioAtendente=
                     "<form action='Cadastrar_Funcionario' method='post'>"+
                     "Nome:<br><input type='text' name='nomea' size=20><br>"+
                     "Cpf:<br><input type='text' name='cpfa' size=20><br>"+
                     "Email:<br><input type='text' name='emaila' size=20><br>"+
                     "Login:<br><input type='text' name='logina' size=20><br>"+
                     "Senha:<br><input type='text' name='senhaa' size=20><br>"+
                     "Data de Nascimento:<br><input type='date' name='data_nasa' size=20><br>"+
                     "Função<br><input type='text' name='funcaoa' value='Atendente' size=20 readonly><br>"+
                     "<input type='hidden' name='funcaoOculta' value='Atendente'>"+
                     "<input type='submit' value='cadastrar' style='margin-top:15px'>"+
                     "</form>";
                    
         String formularioEnfermeiro=
                    "<form action='Cadastrar_Funcionario' method='post'>"+
                     "Nome:<br><input type='text' name='nomee' size=20><br>"+
                     "Cpf:<br><input type='text' name='cpfe' size=20>"+
                     "Email:<br><input type='text' name='emaile' size=20>"+
                     "Login:<br><input type='text' name='logine' size=20>"+
                     "Senha:<br><input type='text' name='senhae' size=20><br>"+
                     "Data Nascimento:<br><input type='date' name='data_nase' size=20><br>"+
                     "Funcao:<br><input type='text' name='funcaoe' value='Enfermeiro' size=20 readonly>"+
                     "Especialidade:<br><input type='text' name='especialidadee' size=20>"+
                     "CRM:<br><input type='text' name='crme' size=20><br>"+
                     "<input type='hidden' name='funcaoOculta' value='Enfermeiro'>"+
                     "<input type='submit' value='cadastrar' style='margin-top:15px'>"+
                     "</form>"; 
         String cadastroRealizado=
                "<center><h2 style='color:green;'>Cadastro realizado com sucesso!!</h2></center>"+
                 "<form action='Login.jsp' method='get'>"+
                 "<input type='submit' value='Voltar Para o menu' style='margin-top:15px'>"+
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

                }else if(funcaostr.equals("Atendente")){
                    out.println(formularioAtendente);
                }else if (funcaostr.equals("Enfermeiro")){
                    out.println(formularioEnfermeiro);
                }
            
                
            
            
            
            
            
            
            
            
            %>
            
              
            
            
        </div>
    </body>
</html>
