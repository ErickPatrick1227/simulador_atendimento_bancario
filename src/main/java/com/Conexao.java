package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static  final String URL = "jdbc:mysql://localhost:3306/simulador_db?serverTimezone=UTC";
    private static  final String USER = "simulador_user";
    private static  final String PASSWORD = "senha123";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
