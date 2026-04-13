import java.sql.*;

public class TestDB {
    public static void main(String args[]) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/demo", "root", "root29");

            System.out.println("Connected");

            Statement stmt = con.createStatement();

            // SELECT query
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                System.out.println(
                    rs.getInt(1) + " " +
                    rs.getString(2) + " " +
                    rs.getString(3)
                );
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}