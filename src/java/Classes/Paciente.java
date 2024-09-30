
package Classes;
import conexaoBanco.ConexaoPostgres;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class Paciente {
   
    private String nome;
    private String endereco;
    private String data_paciente;
    private String cpf;
    private String email;
    private String telefone;
    private String convenio;
    private String status;
    private String risco;
    private String especialidade_consulta;
  
            
    public Paciente(String nome, String endereco, String data_paciente, String cpf, String email, String telefone, String convenio,String status) {
        this.nome = nome;
        this.endereco = endereco;
        this.data_paciente = data_paciente;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.convenio = convenio;
        this.status= status;
    }
    public Paciente(){
    
    
    } 

    
  
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getData_paciente() {
        return data_paciente;
    }

    public void setData_paciente(String data_paciente) {
        this.data_paciente = data_paciente;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }
      public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }

    public String getEspecialidade_consulta() {
        return especialidade_consulta;
    }

    public void setEspecialidade_consulta(String especialida_consulta) {
        this.especialidade_consulta = especialida_consulta;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
