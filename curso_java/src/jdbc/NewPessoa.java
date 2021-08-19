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

		// SEGURAN�A: para evitar ataques de SQL INJECTION est� sendo utilizada
		// a interface PrepareStatement, que implementa um m�todo seguro
		// ao proteger os dados inseridos no banco, removendo poss�veis
		// comandos SQL que sejam enviados junto com os dados por concatena��o
		String sql = "INSERT INTO pessoas (nome) VALUES (?)"; // o par�metro nome � referenciado pela interroga��o
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, nome); // aqui informamos qual valor ser� atribu�do para o par�metro que foi referenciado acima

		stmt.execute();

		System.out.println("Pessoa inclu�da com sucesso");

		entrada.close();
	}
}
