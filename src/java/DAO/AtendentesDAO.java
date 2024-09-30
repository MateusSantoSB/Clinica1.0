
package DAO;
import java.sql.*;
import Classes.Atendentes;
import conexaoBanco.ConexaoPostgres;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
public class AtendentesDAO {
    
    String sqlComando;
    PreparedStatement pStatement;
    ResultSet rs;
    
    
    public void cadastrarAtendente(Atendentes atendentes){
        sqlComando="INSERT INTO atendentes (nome,cpf,email,login,senha,data_nas,funcao)VALUES(?,?,?,?,?,?,?)";
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(atendentes.getData_nas(), formatter);
        java.sql.Date Datasql = java.sql.Date.valueOf(localDate);   
        
        try {
            
            pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
            
            pStatement.setString(1, atendentes.getNome() );
            pStatement.setString(2, atendentes.getCpf() );
            pStatement.setString(3, atendentes.getEmail() );
            pStatement.setString(4, atendentes.getLogin() );
            pStatement.setString(5, atendentes.getSenha() );
            pStatement.setDate(6, Datasql);
            pStatement.setString(7, atendentes.getFuncao() );
            
            pStatement.executeUpdate();
            
            
        } catch (SQLException e) {
        }
        
    
    }
    
    public void deletarAtendentes(Atendentes atendentes){
     sqlComando="DELETE FROM atendentes WHERE cpf=?";
     
        try {
            
            pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
            pStatement.setString(1, atendentes.getCpf());
            
            pStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public List<String> listarAtendentes(){
       sqlComando="SELECT * FROM atendentes";
       List<String> listaAtendentes=new ArrayList<>();
         try {
             pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
             
             rs=pStatement.executeQuery();
             
          while(rs.next()){
          
          String listaDAtendentes=rs.getString("nome");
          listaAtendentes.add(listaDAtendentes);
          
          }    
        } catch (SQLException e) {
        }
    
         return listaAtendentes;
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
