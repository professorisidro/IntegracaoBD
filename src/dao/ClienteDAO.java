/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cliente;

/**
 *
 * @author TheMatrix
 */
public class ClienteDAO {
    private DataSource dataSource;
    
    public ClienteDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    public ArrayList<Cliente> readAll(){
        try{
            String SQL = "SELECT * FROM cliente";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            
            ArrayList<Cliente> lista = new ArrayList<Cliente>();
            
            while(rs.next()){
                Cliente cli = new Cliente();
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setEmail(rs.getString("email"));
                cli.setTelefone(rs.getString("telefone"));
                lista.add(cli);
            }
            ps.close();
            return lista;
            
        }
        catch (SQLException ex){
            System.err.println("Erro ao recuperar "+ex.getMessage());
        }
        catch(Exception ex){
            System.err.println("Erro geral..."+ex.getMessage());
        }
        return null;
        
    }
    
}
