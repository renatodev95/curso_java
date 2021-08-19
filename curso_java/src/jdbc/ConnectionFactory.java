package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	// criando uma F�brica de Conex�es para reaproveitamento de c�digo
	public static Connection getConnection() {

		try {

			String url = "jdbc:mysql://localhost/curso_java?verifyServerCertificate=false&useSSL=true";
			String usuario = "root";
			String senha = "12345678";
			return DriverManager.getConnection(url, usuario, senha);

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}

	}
}
