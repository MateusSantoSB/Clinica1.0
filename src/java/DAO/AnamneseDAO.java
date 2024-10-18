/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Classes.Anamnese;
import conexaoBanco.ConexaoPostgres;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author mateu
 */
public class AnamneseDAO {
    String sqlComando;
    PreparedStatement pStatement;
    ResultSet rs;
    
    
    public void criarAnamnese(String relatorio,String cpf,String nome_enfermeiro,String registro,String especialidade) {
        sqlComando="INSERT INTO anamnese(relatorio,cpf_paciente,data,hora,nome_enfermeiro,registro,especialidade) VALUES (?,?,?,?,?,?,?)";
        LocalDate data= LocalDate.now();
        LocalTime hora= LocalTime.now();
        
        DateTimeFormatter formatadorData=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String data1=data.format(formatadorData);
        LocalDate localDate = LocalDate.parse(data1, formatadorData);
        java.sql.Date Datasql = java.sql.Date.valueOf(localDate); 
        
        
        DateTimeFormatter formatadorHora=DateTimeFormatter.ofPattern("HH:mm:ss");
        String hora1=hora.format(formatadorHora);
        try {
            pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
            
            pStatement.setString(1, relatorio);
            pStatement.setString(2, cpf);
            pStatement.setDate(3, Datasql);
            pStatement.setString(4, hora1);
            pStatement.setString(5, nome_enfermeiro);
            pStatement.setString(6, registro);
            pStatement.setString(7, especialidade);
            pStatement.executeUpdate();   
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }



    public List<Anamnese> listarAnamnese(String cpf){
    List<Anamnese> listarAnamnese=new ArrayList<>();
    sqlComando="SELECT * FROM anamnese WHERE cpf_paciente=?";
            
        try {
            pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
            
            pStatement.setString(1, cpf);
            
            rs=pStatement.executeQuery();
            
            while(rs.next()){
            Anamnese anamnese=new Anamnese();
            
            anamnese.setRelatorio(rs.getString("relatorio"));
            anamnese.setCpf(rs.getString("cpf_paciente"));
            anamnese.setData(rs.getDate("data"));
            anamnese.setHora(rs.getString("hora"));
            anamnese.setNome_enfermeiro(rs.getString("nome_enfermeiro"));
            anamnese.setRegsitro(rs.getString("registro"));
            anamnese.setEspecialidade(rs.getString("especialidade"));
                    
           listarAnamnese.add(anamnese);                 
            }
    
        } catch (SQLException ex) {
            Logger.getLogger(AnamneseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return listarAnamnese;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
