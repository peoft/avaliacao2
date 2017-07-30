package av2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	String driverClassName = "com.mysql.jdbc.Driver";
	private static ConnectionFactory connectionFactory = null;

	private ConnectionFactory() {  
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
		}
	}

	public Connection getConnection(String connectionUrl, String dbUser, String dbPwd) throws SQLException {
		Connection conn;
		conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
		return conn;
	}

	public static ConnectionFactory getInstance() {
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}
}
