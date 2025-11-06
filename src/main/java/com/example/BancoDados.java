package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BancoDados {
    private static final String URL = "jdbc:mysql://localhost:3306/simulador_db";
    private static final String USER = "simulador_user";
    private static final String PASS = "senha123";

    public List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT id, nome, prioridade, chegada, tempo_servico, status FROM clientes";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            {

                while (rs.next()) {
                    clientes.add(mapCliente(rs));
                }
            }

        } catch (SQLDataException e) {
            System.err.println("Erro de dados SQL: " + e.getMessage());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clientes;
    }

    private Cliente mapCliente(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String nome = rs.getString("nome");
        int prioridade = rs.getInt("prioridade");
        String chegada = rs.getString("chegada");
        double tempoServico = rs.getDouble("tempo_servico");
        String status = rs.getString("status");

        return new Cliente(id, nome, prioridade, chegada, tempoServico, status);
    }
}
