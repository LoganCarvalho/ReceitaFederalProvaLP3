
package Mode.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class connectionFactory {
    
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String usuario = "root";
    private static final String senha = "";
    private static final String url = "jdbc:mysql://localhost";

    private static Connection conn = null;

    public static Connection getConnection() {

        try {
            //Carregar o driver JDBC
            Class.forName(driver);
            //Criar uma conexão com o banco
            conn = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("erro, verifique se o driver foi incluido como biblioteca do projeto ou procure o administrador do sistema.");
            throw new RuntimeException(e);
        }
        return conn;
    }

    // Chamando métodos para fechar as conexões
    public static void FecharConexao(Connection conn, PreparedStatement pstm, ResultSet rs) throws Exception {
        Fechar(conn, pstm, rs);
    }

    public static void FecharConexao(Connection conn, PreparedStatement pstm) throws Exception {
        Fechar(conn, pstm, null);
    }

    public static void FecharConexao(Connection conn) throws Exception {
        Fechar(conn, null, null);
    }

    private static void Fechar(Connection conn, PreparedStatement pstm, ResultSet rs) throws Exception {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
