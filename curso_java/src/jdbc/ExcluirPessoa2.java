package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ExcluirPessoa2 {

	public static void main(String[] args) throws SQLException {

		Scanner scan = new Scanner(System.in);
		System.out.println("Abaixo está a lista de registros da tabela `pessoas`.");

		Connection con = ConnectionFactory.getConnection();
		String selectSQL = "SELECT codigo, nome FROM pessoas";

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSQL);

		executarSelectNaTabela(rs);

		System.out.print("\nInforme o código da pessoa a ser excluída: ");
		int codigo = scan.nextInt();
		scan.nextLine();

		String selectCodigoSQL = "SELECT nome FROM pessoas WHERE codigo = ?";
		PreparedStatement pstmt = con.prepareStatement(selectCodigoSQL);
		pstmt.setInt(1, codigo);

		rs = pstmt.executeQuery();

		if (rs.next()) {

			Pessoa pessoa = new Pessoa(codigo, rs.getString(1));
			System.out.print("Você selecionou " + pessoa.getNome() + ", deseja realmente excluir? [S/n] ");
			char confirmacao = scan.next().charAt(0);

			if (confirmacao == 'S' || confirmacao == 's') {

				String deleteSQL = "DELETE FROM pessoas WHERE codigo = ?";
				pstmt = con.prepareStatement(deleteSQL);
				pstmt.setInt(1, codigo);
				pstmt.execute();
				System.out.println("O cadastro de " + pessoa.getNome() + " foi excluído com sucesso." + "\n");

				rs = stmt.executeQuery(selectSQL);
				executarSelectNaTabela(rs);

			} else {
				System.out.println("O registro não será excluído.");
			}

		} else {
			System.out.println("Este código não está presente na tabela!");
		}

		stmt.close();
		pstmt.close();
		con.close();
		scan.close();
	}

	static void executarSelectNaTabela(ResultSet rs) throws SQLException {

		System.out.println("Código \t Nome");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t " + rs.getString(2));
		}

	}
}
