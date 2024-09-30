
package DAO;

import Classes.Paciente;
import conexaoBanco.ConexaoPostgres;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



    




public class PacienteDAO {
    
    
    String sqlComando;
    PreparedStatement pStatement;
    ResultSet rs;
    
    
    
    public void cadastrarPaciente(Paciente pacientes){
        sqlComando="INSERT INTO pacientes (nome,endereco,data_paciente,cpf,email,telefone,convenio,status) VALUES (?,?,?,?,?,?,?,?)";
        

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(pacientes.getData_paciente(), formatter);
        java.sql.Date Datasql = java.sql.Date.valueOf(localDate);        
                
                
        try {
            pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
            
            
            pStatement.setString(1, pacientes.getNome());
            pStatement.setString(2, pacientes.getEndereco());
            pStatement.setDate(3, Datasql);
            pStatement.setString(4, pacientes.getCpf());
            pStatement.setString(5, pacientes.getEmail());
            pStatement.setString(6, pacientes.getTelefone());
            pStatement.setString(7, pacientes.getConvenio());
            pStatement.setString(8, pacientes.getStatus());
            
            pStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }

       
    
    
    }
    
    
    public List<Paciente> listarPaciente(){
        List<Paciente> listaPacientes=new ArrayList<>();
        sqlComando="SELECT * FROM pacientes";
        try { 
            pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
            rs=pStatement.executeQuery();
            while(rs.next()){
           Paciente paciente=new Paciente(); 
          paciente.setNome(rs.getString("nome")); 
          paciente.setConvenio(rs.getString("convenio"));
          paciente.setCpf(rs.getString("cpf"));
          
                       
            listaPacientes.add(paciente);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPacientes;
    }
    
    
    public List<Paciente> listarPacientePorCpf(String cpf){
        List<Paciente> listaPacientes=new ArrayList<>();
        sqlComando="SELECT * FROM pacientes WHERE cpf=?";
        Paciente paciente=new Paciente(); 
        
        try { 
            pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
            pStatement.setString(1, cpf);
            
            rs=pStatement.executeQuery();
            while(rs.next()){
          
          paciente.setNome(rs.getString("nome")); 
          paciente.setConvenio(rs.getString("convenio"));
          paciente.setCpf(rs.getString("cpf"));

                       
            listaPacientes.add(paciente);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPacientes;
    }
    
    
    public String buscarPaciente (String cpf) {
         sqlComando="SELECT * FROM pacientes WHERE cpf=?";
         
         String nome="";
         
         try {
            
            pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
            
            pStatement.setString(1, cpf);
            
           rs=pStatement.executeQuery();
            
      
             while(rs.next()){
                 
             nome=rs.getString("nome");
             }
             
               
          
          
            
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
            return nome;
    }
    
    
    public void mudarStatusTriagem(String cpf,String status) {
        sqlComando="UPDATE pacientes SET status=?  WHERE cpf=? ";
      
        try {
            pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
            
            pStatement.setString(1, status);
            pStatement.setString(2, cpf);
            pStatement.executeUpdate(); 
            
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    public void definirRiscoeEspecialidadeConsulta(String risco,String especialidade,String cpf){
    sqlComando="UPDATE pacientes SET risco=?,especialidade_consulta=? WHERE cpf=? ";
    
        try {
            pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
            
            pStatement.setString(1, risco );
            pStatement.setString(2, especialidade );
            pStatement.setString(3, cpf );
            
            pStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
            
            
            
    public String buscarPorNome(String nome){
    sqlComando="SELECT cpf FROM pacientes WHERE nome=?";
    String cpf="";
        try {
            pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
            pStatement.setString(1, nome);
            rs=pStatement.executeQuery();
            
            while(rs.next()){
            
           cpf=rs.getString("cpf");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cpf;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public List<Paciente> listarPacienteNome(){
        List<Paciente> listaPacientes=new ArrayList<>();
        sqlComando="SELECT * FROM pacientes";
        try { 
            pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
            rs=pStatement.executeQuery();
            while(rs.next()){
           Paciente paciente=new Paciente(); 
          paciente.setNome(rs.getString("nome")); 
       

                       
            listaPacientes.add(paciente);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPacientes;
    }
    
    
    
    
    
    //NAO E POSSIVEL DELETAR PACIENTES !!!
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
