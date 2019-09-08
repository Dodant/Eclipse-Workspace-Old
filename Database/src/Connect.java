import java.sql.*;

public class Connect {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcURL = "jdbc:mysql://localhost:3306/SQLhw?verifyServerCertificate=false&useSSL=false";
			String jdbcID = "root";
			String jdbcPWD = "noeticgu2@";
			conn = DriverManager.getConnection(jdbcURL, jdbcID, jdbcPWD);
			System.out.println("DB연결완료");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 연결 에러");
		}

	}
}