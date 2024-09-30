
package Classes;



public class Atendentes {
   

   private String nome;
   private String cpf;
   private String email; 
   private String login;
   private String senha;
   private String data_nas;
   private String funcao;

    public Atendentes(String nome, String cpf, String email, String login, String senha, String data_nas, String funcao) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.data_nas = data_nas;
        this.funcao = funcao;
    }
    
    public Atendentes(){
    
    
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getData_nas() {
        return data_nas;
    }

    public void setData_nas(String data_nas) {
        this.data_nas = data_nas;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
