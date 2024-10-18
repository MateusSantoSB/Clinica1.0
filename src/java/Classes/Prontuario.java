
package Classes;


import java.sql.Date;

public class Prontuario {
    
    private String relatorio;
    private String cpf_paciente;
    private Date data;
    private String hora;
    private String especialidade;
    private String nome_medico;
    private String crm;

    public Prontuario(String relatorio, String cpf_paciente,String especialidade,String nome_medico,String crm) {
        this.relatorio = relatorio;
        this.cpf_paciente = cpf_paciente;
        this.especialidade=especialidade;
        this.nome_medico=nome_medico;
        this.crm=crm;
    }
    
    public Prontuario(){
    
    
    }
    
    
    
    

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getNome_medico() {
        return nome_medico;
    }

    public void setNome_medico(String nome_medico) {
        this.nome_medico = nome_medico;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public String getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    public String getCpf_paciente() {
        return cpf_paciente;
    }

    public void setCpf_paciente(String cpf_paciente) {
        this.cpf_paciente = cpf_paciente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
    
    
    
    
    
}
