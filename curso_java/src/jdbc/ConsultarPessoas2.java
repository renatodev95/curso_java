package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarPessoas2 {

	// Consultando com SELECT utilizando o LIKE

	public static void main(String[] args) throws SQLException {

		Scanner entrada = new Scanner(System.in);

		Connection conexao = ConnectionFactory.getConnection();

		String valor = entrada.nextLine();

		String sql = "SELECT * FROM pessoas WHERE nome LIKE ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, "%" + valor + "%");
		ResultSet res = stmt.executeQuery();

		List<Pessoa> pessoas = new ArrayList<>();

		while (res.next()) {
			int codigo = res.getInt("codigo");
			String nome = res.getString("nome");
			pessoas.add(new Pessoa(codigo, nome));
		}

		for (Pessoa p : pessoas) {
			System.out.println(p.getCodigo() + "  " + p.getNome());
		}

		stmt.close();
		conexao.close();
		entrada.close();
	}
}
