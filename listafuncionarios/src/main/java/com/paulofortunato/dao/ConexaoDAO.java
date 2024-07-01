package com.paulofortunato.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {   
    //Método de conexão com o banco de dados
    public Connection conectaBD(){
        Connection conn = null;
        
        try{
            
            String url = "jdbc:mysql://localhost:3306/banco_teste?user=root&password=123456";
            conn = DriverManager.getConnection(url);

        } catch (SQLException erro) {
            System.out.println("ConexaoDAO" + erro.getMessage());
        }
        return conn;
    }

}