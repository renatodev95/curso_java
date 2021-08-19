package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AlterarNomePessoa {

	// DESAFIO: receba um codigo como primeiro parâmetro e
	// atualize o nome registrado nesse código através de um nome lido no Scanner

	public static void main(String[] args) throws SQLException {

		Scanner entry = new Scanner(System.in);
		Connection con = ConnectionFactory.getConnection();

		System.out.print("Informe o código da pessoa: ");
		int codigo = entry.nextInt();

		String selectSQL = "SELECT codigo, nome FROM pessoas WHERE codigo = ?";
		String updateSQL = "UPDATE pessoas SET nome = ? WHERE codigo = ?";

		PreparedStatement pstmt = con.prepareStatement(selectSQL);
		pstmt.setInt(1, codigo);

		ResultSet res = pstmt.executeQuery();

		if (res.next()) {
			Pessoa p = new Pessoa(res.getInt(1), res.getString(2));
			System.out.println("O nome atual é: " + p.getNome());
			entry.nextLine(); // evitando o problema do nextInt anterior

			System.out.print("Informe o novo nome: ");
			String newName = entry.nextLine();

			pstmt.close();

			pstmt = con.prepareStatement(updateSQL);
			pstmt.setString(1, newName);
			pstmt.setInt(2, codigo);
			pstmt.execute();

			System.out.println("Pessoa alterada com sucesso!");
		} else {
			System.out.println("Pessoa não encontrada!");
		}

		con.close();
		pstmt.close();
		entry.close();

	}
}
