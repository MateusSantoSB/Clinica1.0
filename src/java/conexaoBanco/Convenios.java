
package conexaoBanco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Convenios {
    private int id;
    private String nome_empresa;
    private String cnpj;
    private String telefone;
    
    
    static PreparedStatement pStatement;
    static  String sqlComando;
    static ResultSet rs;
    public Convenios(){

    }

    
    
    
    
    
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    
    
    
    
   public static List<String> listarConvenios(){
        sqlComando="SELECT nome_empresa FROM convenios ";
        List<String> listanomeEmpresa= new ArrayList<>();
        
        try {
            pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
            rs=pStatement.executeQuery();
            
            while (rs.next()){
            String nomesEmpresa=rs.getString("nome_Empresa");
            listanomeEmpresa.add(nomesEmpresa);
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(Convenios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listanomeEmpresa;
    
    
    }
    
    
    
    
}
