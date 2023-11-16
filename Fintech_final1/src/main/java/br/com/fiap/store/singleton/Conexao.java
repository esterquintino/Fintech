package br.com.fiap.store.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private static final String USUARIO = "rm99592";
    private static final String SENHA = "070786";

    private static Connection conexao;

    // Construtor privado para evitar instanciação externa
    private Conexao() {
    }

    // Método para obter a instância única da conexão
    public static Connection obterConexao() throws SQLException {
        if (conexao == null || conexao.isClosed()) {
            inicializarConexao();
        }
        return conexao;
    }

    private static void inicializarConexao() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão estabelecida com sucesso.");
        } catch (ClassNotFoundException e) {
            System.err.println("Erro: Classe do driver não encontrada.");
            e.printStackTrace();
            throw new SQLException("Erro ao inicializar a conexão.", e);
        } catch (SQLException e) {
            System.err.println("Erro: Não foi possível estabelecer a conexão.");
            e.printStackTrace();
            throw new SQLException("Erro ao inicializar a conexão.", e);
        }
    }

    public static void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("Conexão fechada com sucesso.");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão.");
                e.printStackTrace();
            }
        }
    }

}
