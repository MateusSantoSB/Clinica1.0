
package DAO;


import conexaoBanco.ConexaoPostgres;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Classes.Convenios;
import java.sql.DriverManager;

public class ConveniosDAO {
    
    
    
    
    
    
    
    
    
    
    PreparedStatement pStatement;
     String sqlComando;
    ResultSet rs;
    
    
    
    
       public  List<String> listarConvenios(){
        sqlComando="SELECT nome_empresa FROM convenios ";
        List<String> listanomeEmpresa= new ArrayList<>();
        
        try {
            pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
            rs=pStatement.executeQuery();
            
            while (rs.next()){
            String nomesEmpresa=rs.getString("nome_empresa");
            listanomeEmpresa.add(nomesEmpresa);
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(Convenios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listanomeEmpresa;
    }
   
   
     public  void cadastrarConvenio(Convenios convenios){
    sqlComando="INSERT INTO convenios (nome_empresa,cnpj,telefone) VALUES(?,?,?)";
    try{  
        pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
        
        pStatement.setString(1, convenios.getNome_empresa());
        pStatement.setString(2, convenios.getCnpj());
        pStatement.setString(3, convenios.getTelefone() );
    
        pStatement.executeUpdate();
    }catch(SQLException e){

    }
    }
    
    public  void deletarConvenio(Convenios convenios){
        sqlComando="DELETE FROM convenios WHERE cnpj=?";    
        
        try {
            
            pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
            
            pStatement.setString(1, convenios.getCnpj());
            
            pStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Convenios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}
    
    
    
    
}
