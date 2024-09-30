
package Classes;


public class Enfermeiros {
    
    
    
    private String nome;
    private String cpf;
    private String email;
    private String login;
    private String senha;
    private String data_nas;
    private String funcao;
    private String especialidade;
    private String registro;

    public Enfermeiros(String nome, String cpf, String email, String login, String senha, String data_nas, String funcao, String especialidade, String registro) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.data_nas = data_nas;
        this.funcao = funcao;
        this.especialidade = especialidade;
        this.registro = registro;
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

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getRegistro() {
        return registro;
    }

    public void setCrm(String registro) {
        this.registro = registro;
    }
    
    
    
}
