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
		System.out.println("Abaixo est� a lista de registros da tabela `pessoas`.");

		Connection con = ConnectionFactory.getConnection();
		String selectSQL = "SELECT codigo, nome FROM pessoas";

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSQL);

		executarSelectNaTabela(rs);

		System.out.print("\nInforme o c�digo da pessoa a ser exclu�da: ");
		int codigo = scan.nextInt();
		scan.nextLine();

		String selectCodigoSQL = "SELECT nome FROM pessoas WHERE codigo = ?";
		PreparedStatement pstmt = con.prepareStatement(selectCodigoSQL);
		pstmt.setInt(1, codigo);

		rs = pstmt.executeQuery();

		if (rs.next()) {

			Pessoa pessoa = new Pessoa(codigo, rs.getString(1));
			System.out.print("Voc� selecionou " + pessoa.getNome() + ", deseja realmente excluir? [S/n] ");
			char confirmacao = scan.next().charAt(0);

			if (confirmacao == 'S' || confirmacao == 's') {

				String deleteSQL = "DELETE FROM pessoas WHERE codigo = ?";
				pstmt = con.prepareStatement(deleteSQL);
				pstmt.setInt(1, codigo);
				pstmt.execute();
				System.out.println("O cadastro de " + pessoa.getNome() + " foi exclu�do com sucesso." + "\n");

				rs = stmt.executeQuery(selectSQL);
				executarSelectNaTabela(rs);

			} else {
				System.out.println("O registro n�o ser� exclu�do.");
			}

		} else {
			System.out.println("Este c�digo n�o est� presente na tabela!");
		}

		stmt.close();
		pstmt.close();
		con.close();
		scan.close();
	}

	static void executarSelectNaTabela(ResultSet rs) throws SQLException {

		System.out.println("C�digo \t Nome");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t " + rs.getString(2));
		}

	}
}
