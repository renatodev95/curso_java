package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {

	public static void main(String[] args) throws SQLException{
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Informe o código: ");
		int codigo = scan.nextInt();
		
		Connection con = ConnectionFactory.getConnection();
		String sql = "DELETE FROM pessoas WHERE codigo = ?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, codigo);
		
		int contador = pstmt.executeUpdate();
		
		if (contador > 0) {
			System.out.println("Pessoa excluída com sucesso!");
			System.out.printf("Linhas afetadas: %d", contador);
		} else {
			System.out.println("Nada feito!");
		}
		
		con.close();
		scan.close();
	}
}
