package br.com.fiap.store.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.fiap.fintech.exception.DBException;

public class Conexao {

    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private static final String USUARIO = "rm552358";
    private static final String SENHA = "190597";

    private static Connection conexao;

    private Conexao() {
    }

    public static Connection obterConexao() throws DBException {
        if (conexao == null || estaFechada()) {
            inicializarConexao();
        } else if (estaFechada()) {
            System.out.println("A conexão está fechada. Tentando reabrir a conexão...");
            reabrirConexao();
        }

        System.out.println("Obtendo conexão...");
        return conexao;
    }

    private static void inicializarConexao() throws DBException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão estabelecida com sucesso.");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Erro ao inicializar a conexão.");
            e.printStackTrace();
            throw new DBException("Erro ao inicializar a conexão.", e);
        }
    }

    public static void fecharConexao() throws DBException {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("Conexão fechada com sucesso.");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão.");
                e.printStackTrace();
                throw new DBException("Erro ao fechar a conexão.", e);
            }
        }
    }

    public static boolean estaFechada() throws DBException {
        try {
            return conexao == null || conexao.isClosed();
        } catch (SQLException e) {
            System.err.println("Erro ao verificar se a conexão está fechada.");
            e.printStackTrace();
            throw new DBException("Erro ao verificar se a conexão está fechada.", e);
        }
    }

    public static void reabrirConexao() throws DBException {
        fecharConexao();
        inicializarConexao();
    }
}
