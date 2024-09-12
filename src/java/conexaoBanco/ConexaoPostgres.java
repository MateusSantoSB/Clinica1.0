
package conexaoBanco;
import java.sql.*;

/**
 *
 * @author mateu
 */
public class ConexaoPostgres {
    
    private static Connection conexao;
    
    
public static Connection getConexao(){
try{
   if (conexao==null){
        conexao=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","123");
        return conexao;
   }else{
        return conexao;
   
   }
   
}catch(SQLException e){
    return null;
}

}
   
    

    
}