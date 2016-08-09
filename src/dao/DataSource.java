/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author TheMatrix
 */
public class DataSource {
    
    private String hostname;
    private int    port;
    private String database;
    private String username;
    private String password;
    
    private Connection connection;
    
    public DataSource(){
        try{
            hostname = "localhost";
            port     = 3306;
            database = "javabd";
            username = "root";
            password = "mysql";
            
            String url = "jdbc:mysql://"+hostname+":"+port+"/"+database;
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection(url, username, password);
            
            System.out.println("Deu certo...");
        }
        catch(SQLException ex){
            System.err.println("ERRO na Conexao "+ex.getMessage());
        }
        catch(Exception ex){
            System.err.println("Erro geral "+ex.getMessage());
        }
        
    }
    
    public Connection getConnection(){
        return this.connection;
    }
    
    public void closeDataSource(){
        try{
            connection.close();
        }
        catch(Exception ex){
            System.err.println("Erro ao desconectar "+ex.getMessage());
        }
        
    }
    
    
    
}
