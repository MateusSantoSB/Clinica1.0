
package DAO;


import Classes.Enfermeiros;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import Classes.Medicos;
import conexaoBanco.ConexaoPostgres;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {
    String sqlComando;
    PreparedStatement pStatement;
    ResultSet rs;
    
    
    
    public void cadastrarMedico(Medicos medicos){
         sqlComando="INSERT INTO medicos (nome,cpf,email,login,senha,data_nas,funcao,especialidade,crm)VALUES(?,?,?,?,?,?,?,?,?)";

        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(medicos.getData_nas(), formatter);
        java.sql.Date Datasql = java.sql.Date.valueOf(localDate);   
    
        try {
            
            pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
            
            pStatement.setString(1, medicos.getNome() );
            pStatement.setString(2, medicos.getCpf() );
            pStatement.setString(3, medicos.getEmail() );
            pStatement.setString(4, medicos.getLogin() );
            pStatement.setString(5, medicos.getSenha() );
            pStatement.setDate(6, Datasql);
            pStatement.setString(7, medicos.getFuncao() );
            pStatement.setString(8, medicos.getEspecialidade());
            pStatement.setString(9, medicos.getCrm());
            
            pStatement.executeUpdate();
            
            
        } catch (SQLException e) {
        }  
    }
    
    
    public  List<Medicos> listarMedicosPorCrm(String crmBuscar){
       sqlComando="SELECT * FROM medicos WHERE crm=?";
       List<Medicos> listaMedicos=new ArrayList<>();
     
         try {
             pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
             pStatement.setString(1, crmBuscar );
            
             rs=pStatement.executeQuery();
             
          while(rs.next()){
          Medicos medicos=new Medicos();
          
          medicos.setNome(rs.getString("nome"));
          medicos.setCrm(rs.getString("crm"));
          medicos.setEspecialidade(rs.getString("especialidade"));
          
          listaMedicos.add(medicos);
          
          }    
        } catch (SQLException e) {
        }
    
         return listaMedicos;
    
    }
    
    public  List<Medicos> listarMedicos(){
       sqlComando="SELECT * FROM medicos ";
       List<Medicos> listaMedicos=new ArrayList<>();
     
         try {
             pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
           
            
             rs=pStatement.executeQuery();
             
          while(rs.next()){
          Medicos medicos=new Medicos();
          
          medicos.setNome(rs.getString("nome"));
          medicos.setCrm(rs.getString("crm"));
          medicos.setEspecialidade(rs.getString("especialidade"));
          
          listaMedicos.add(medicos);
          
          }    
        } catch (SQLException e) {
        }
    
         return listaMedicos;
    
    }
    
    
    
    
    public void deletarEnfermeiros(Medicos medicos){
        sqlComando="DELETE FROM medicos WHERE crm=? ";
        
        try {
            pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
            
            pStatement.setString(1, medicos.getCrm());
            pStatement.executeUpdate();
            
            
            
        } catch (SQLException e) {
        }
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
