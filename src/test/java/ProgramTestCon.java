import java.sql.Connection;
import java.sql.DriverManager;

public class ProgramTestCon {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost/productdb";
            String username = "root";
            String password = "1234567890qwe!Q";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                System.out.println("Connection to Store DB succesfull!");
            }
        } catch (Exception e) {
            System.out.println("connection fail");

            System.out.println(e);


        }
    }
}



