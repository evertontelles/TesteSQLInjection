/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.tas.pgbd.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Everton
 */
public class ConexaoSingleton {

    private static ConexaoSingleton conexao;
    Connection conn =null;
    
    private ConexaoSingleton(String servidor, String usuario, String senha) throws SQLException {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conn = DriverManager.getConnection("jdbc:mysql://" + servidor, usuario, senha );
    }

    public static Connection getConexao(String servidor, String usuario, String senha) throws SQLException {

        try {
            if (conexao == null) {
                conexao = new ConexaoSingleton(servidor, usuario, senha);
            }
            return conexao.conn;
        } catch (SQLException ex) {
            throw ex;
        }
    }
    public static Connection getConexao() throws SQLException {

            if (conexao == null) {
                throw   new SQLException("No database connected!");
                
            }
            return conexao.conn;
    }

}
