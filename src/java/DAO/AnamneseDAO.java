/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexaoBanco.ConexaoPostgres;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
/**
 *
 * @author mateu
 */
public class AnamneseDAO {
    String sqlComando;
    PreparedStatement pStatement;
    
    public void criarAnamnese(String relatorio,String cpf) {
        sqlComando="INSERT INTO anamnese(relatorio,cpf_paciente) VALUES (?,?)  ";
        
        try {
            pStatement=ConexaoPostgres.getConexao().prepareStatement(sqlComando);
            
            pStatement.setString(1, relatorio);
            pStatement.setString(2, cpf);
            pStatement.executeUpdate();   
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
