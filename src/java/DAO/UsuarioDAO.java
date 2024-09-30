
package DAO;

import Classes.Usuario;
import conexaoBanco.ConexaoPostgres;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioDAO {
      PreparedStatement pStatement;
      ResultSet rs;
     String sqlComando;
    
    
    public  List<String> listarUsuarios(){
        sqlComando="SELECT nome FROM usuarios";
        List<String> listaUsuarios=new ArrayList<>();
        
        
        
        
        try {
            pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
            rs=pStatement.executeQuery();
            while(rs.next()){
            String usuarios=rs.getString("nome");
            listaUsuarios.add(usuarios);
            
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaUsuarios; 
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
