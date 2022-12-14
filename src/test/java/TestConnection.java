import java.io.IOException;
import java.sql.*;

public class TestConnection {
    public static final String NAME_USER = "root";
    public static final String PASSWORD = "1234567890qwe!Q";
    public static final String URL = "jdbc:mysql://localhost:3306/productdb";
    public static Connection connection;
    public static Statement statement;

    static {
        try {
            connection = DriverManager.getConnection(URL, NAME_USER, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM products");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(2) + " " +
                    resultSet.getInt(3));
        }
    }
}
