package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NewPessoa {

	public static void main(String[] args) throws SQLException {

		Scanner entrada = new Scanner(System.in);

		System.out.print("Informe o nome: ");
		String nome = entrada.nextLine();

		Connection conexao = ConnectionFactory.getConnection();

		// SEGURANÇA: para evitar ataques de SQL INJECTION está sendo utilizada
		// a interface PrepareStatement, que implementa um método seguro
		// ao proteger os dados inseridos no banco, removendo possíveis
		// comandos SQL que sejam enviados junto com os dados por concatenação
		String sql = "INSERT INTO pessoas (nome) VALUES (?)"; // o parâmetro nome é referenciado pela interrogação
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, nome); // aqui informamos qual valor será atribuído para o parâmetro que foi referenciado acima

		stmt.execute();

		System.out.println("Pessoa incluída com sucesso");

		entrada.close();
	}
}
