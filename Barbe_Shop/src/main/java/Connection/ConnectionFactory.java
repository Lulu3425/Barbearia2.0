package Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			return DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/barber_shop", "root", "");
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}




