import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:mydatabase.db";
        ArrayList<User> users = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Successfully connected to SQLite.");
                System.out.println("Connection object: " + conn.getClass().getName());
                conn.prepareStatement(
                        "CREATE TABLE IF NOT EXISTS users(id INTEGER PRIMARY KEY, name TEXT, email TEXT);").execute();
                ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM users");
                while (rs.next()) {
                    users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        users.forEach(user -> System.out.println(users.toString()));
    }
}
