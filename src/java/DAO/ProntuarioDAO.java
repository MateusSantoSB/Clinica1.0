
package DAO;

import Classes.Prontuario;
import java.sql.*;
import conexaoBanco.ConexaoPostgres;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProntuarioDAO {
    PreparedStatement pStatement;
    String sqlComando;
    ResultSet rs;
    
    public void criarProntuario(Prontuario prontuario){
    sqlComando="INSERT INTO prontuario (relatorio,cpf_paciente,data,hora,especialidade,nome_medico,crm) VALUES(?,?,?,?,?,?,?)";
    
        LocalDate data= LocalDate.now();
        LocalTime hora= LocalTime.now();
        
        DateTimeFormatter formatadorData=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String data1=data.format(formatadorData);
        LocalDate localDate = LocalDate.parse(data1, formatadorData);
        java.sql.Date Datasql = java.sql.Date.valueOf(localDate); 
        
        
        DateTimeFormatter formatadorHora=DateTimeFormatter.ofPattern("HH:mm:ss");
        String hora1=hora.format(formatadorHora);
        
        
        prontuario.setData(Datasql);
        prontuario.setHora(hora1);
    
    
    
    
    
        try {
            pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
            
            pStatement.setString(1, prontuario.getRelatorio());
            pStatement.setString(2, prontuario.getCpf_paciente());
            pStatement.setDate(3, prontuario.getData());
            pStatement.setString(4, prontuario.getHora());
            pStatement.setString(5, prontuario.getEspecialidade());
            pStatement.setString(6, prontuario.getNome_medico());
            pStatement.setString(7, prontuario.getCrm());
            pStatement.executeUpdate();
        } catch (SQLException e) {
            
        }
    
    
    
    
    }
    
    
    
    public List<Prontuario> listarProntuarios(String cpf){
    List<Prontuario> listaProntuario = new ArrayList<>();
        sqlComando="SELECT * FROM prontuario WHERE cpf_paciente=?";
        
     try {
             pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
             pStatement.setString(1, cpf);
             rs=pStatement.executeQuery();
             
             
             while(rs.next()){
           Prontuario prontuario=new Prontuario();
           prontuario.setRelatorio(rs.getString("relatorio"));
           prontuario.setHora(rs.getString("hora"));
           prontuario.setData(rs.getDate("data"));
           prontuario.setCpf_paciente(rs.getString("cpf_paciente"));
           prontuario.setCrm(rs.getString("crm"));
           prontuario.setNome_medico(rs.getString("nome_medico"));
           prontuario.setEspecialidade(rs.getString("especialidade"));
           listaProntuario.add(prontuario);
             }
             
        } catch (SQLException ex) {
            Logger.getLogger(ProntuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    
        
        return listaProntuario;
    } 
    
    
    
    
    
    
    
    
    
    
    
    
    
}
