
package DAO;
import Classes.Especialidades;
import java.sql.*;
import conexaoBanco.ConexaoPostgres;
import java.util.ArrayList;
import java.util.List;
public class EspecialidadesDAO {
   
    
    String sqlComando;
    PreparedStatement pStatement;
    ResultSet rs;
    
    
    
    
    public void cadastrarEspecialidade(Especialidades especialidades){
        sqlComando="INSERT INTO especialidades (nome,descricao)VALUES (?,?)";
        try {
          pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
            
          pStatement.setString(1, especialidades.getNome());
          pStatement.setString(2, especialidades.getDescricao());
           
          pStatement.executeUpdate();
        } catch (SQLException e) {           
        }

    }
    
    public List<String> listarEspecialidades(){
        List<String> listarEspecialidades=new ArrayList<>();
        sqlComando="SELECT * FROM especialidades";
       
        try {
            pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
            
           rs=pStatement.executeQuery();
          
           while(rs.next()){
           
           String listaEspecialidades=rs.getString("nome");
           listarEspecialidades.add(listaEspecialidades);
           
           }
           
           
           
           
        } catch (SQLException e) {
        }
    
    
        return listarEspecialidades;
    }
    
    
    public void deletarEspecialidade(Especialidades especialidades){
       sqlComando="DELETE FROM especialidades WHERE nome=? ";
       
        try {
            pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
            
            pStatement.setString(1,especialidades.getNome());
            
            pStatement.executeUpdate();
            
        } catch (SQLException e) {
        }
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
