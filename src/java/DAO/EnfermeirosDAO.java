
package DAO;
import java.sql.*;
import Classes.Enfermeiros;
import conexaoBanco.ConexaoPostgres;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
public class EnfermeirosDAO {
    String sqlComando;
    PreparedStatement pStatement;
    ResultSet rs;
    
    public void cadastrarEnfermeiros(Enfermeiros enfermeiros){
        sqlComando="INSERT INTO enfermeiros (nome,cpf,email,login,senha,data_nas,funcao,especialidade,registro)VALUES(?,?,?,?,?,?,?,?,?)";
    
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(enfermeiros.getData_nas(), formatter);
        java.sql.Date Datasql = java.sql.Date.valueOf(localDate);   
        try {
            pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
            
            pStatement.setString(1, enfermeiros.getNome());
            pStatement.setString(2, enfermeiros.getCpf());
            pStatement.setString(3, enfermeiros.getEmail());
            pStatement.setString(4, enfermeiros.getLogin());
            pStatement.setString(5, enfermeiros.getSenha());
            pStatement.setDate(6, Datasql);
            pStatement.setString(7, enfermeiros.getFuncao());
            pStatement.setString(8, enfermeiros.getEspecialidade());
            pStatement.setString(9, enfermeiros.getRegistro());
            
            pStatement.executeUpdate();
            
        } catch (SQLException e) {
        }
    
    }
    
    
    public List<String> listarAtendentes(){
       sqlComando="SELECT * FROM enfermeiros";
       List<String> listaEnfermeiros=new ArrayList<>();
         try {
             pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
             
             rs=pStatement.executeQuery();
             
          while(rs.next()){
          
          String listaDEnfermeiros=rs.getString("registro");
          listaEnfermeiros.add(listaDEnfermeiros);
          
          }    
        } catch (SQLException e) {
        }
    
         return listaEnfermeiros;
    
    }
    
    
    
    public void deletarEnfermeiros(Enfermeiros enfermeiros){
        sqlComando="DELETE FROM enfermeiros WHERE registro=? ";
        
        try {
            pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
            
            pStatement.setString(1, enfermeiros.getRegistro());
            pStatement.executeUpdate();
            
            
            
        } catch (Exception e) {
        }
    
    
    
    
    
    }
    
    
    
    
    
}
