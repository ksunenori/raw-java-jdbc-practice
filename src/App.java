import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:mydatabase.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Successfully connected to SQLite.");
                System.out.println("Connection object: " + conn.getClass().getName());
                conn.prepareStatement(
                        "CREATE TABLE IF NOT EXISTS users(id INTEGER PRIMARY KEY, name TEXT, email TEXT);").execute();
                ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM users");
                while (rs.next()) {
                    System.out.println(rs.getInt("id"));
                    System.out.println(rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
