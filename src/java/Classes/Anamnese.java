/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.Date;

public class Anamnese {
    
    private int id;
    private String cpf;
    private String relatorio;
    private Date data;
    private String hora;
    private String nome_enfermeiro;
    private String regsitro;
    private String especialidade;
    
    
    
    public Anamnese(String cpf, String relatorio) {
        this.cpf = cpf;
        this.relatorio = relatorio;
    }
    
    public Anamnese(){
    
    
    }

    
    
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
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

    public String getNome_enfermeiro() {
        return nome_enfermeiro;
    }

    public void setNome_enfermeiro(String nome_enfermeiro) {
        this.nome_enfermeiro = nome_enfermeiro;
    }

    public String getRegsitro() {
        return regsitro;
    }

    public void setRegsitro(String regsitro) {
        this.regsitro = regsitro;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
