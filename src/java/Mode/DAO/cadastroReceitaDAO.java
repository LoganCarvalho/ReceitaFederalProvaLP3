
package Mode.DAO;

import Model.Bean.declaracaoImpostoRenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class cadastroReceitaDAO {
    
    public int incluir(declaracaoImpostoRenda dir) throws Exception {

        Connection conexao = connectionFactory.getConnection();
        int resposta = 0;
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("insert into ReceitaProva.Declaracao(cpf,ano,nome,receitas,despesas,valorPago,imposto)");
            sql.append(" values(?,?,?,?,?,?,?)");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            stmt.setString(1, dir.getCpf());
            stmt.setString(2, Integer.toString(dir.getAnoReferencia()));
            stmt.setString(3, dir.getNome());
            stmt.setString(4, Float.toString(dir.getValorTotalReceitas()));
            stmt.setString(5, Float.toString(dir.getValorTotalDespesas()));
            stmt.setString(6, Float.toString(dir.getValorPagoImpostoAno()));
            stmt.setString(7, Float.toString(dir.getImposto()));
            stmt.executeUpdate();

        } catch (SQLException error) {
            System.out.println(error.getMessage());
        } finally {
            if (conexao != null) {
                resposta = 1;
                connectionFactory.FecharConexao(conexao);
            }
        }
        return resposta;
    }  
   
}
