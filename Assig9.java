import java.sql.*;
public class Assig9 {
    public static void main(String args[]) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/comp", "root", "root29");

            System.out.println("Connected");

            Statement stmt = con.createStatement();

            // SELECT query
            System.out.println("Initial Employee Table");
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("empID") + "\t" +
                                rs.getString("empName") + "\t" +
                                rs.getString("empRole") + "\t" +
                                rs.getInt("empSalary")
                );
            }
            int insert = stmt.executeUpdate(
                    "INSERT INTO employee VALUES (8, 'Dhinchak', 'Firm manager', 25600 )," +
                            "(9, 'zxy', 'gg2', 12345)"
            );
            System.out.println("\nRecord inserted. Rows affected: " + insert);


            System.out.println("Employee Table After Updation");
            rs = stmt.executeQuery("SELECT * FROM employee");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("empID") + "\t" +
                                rs.getString("empName") + "\t" +
                                rs.getString("empRole") + "\t" +
                                rs.getInt("empSalary")
                );
            }

            int delete = stmt.executeUpdate("DELETE FROM employee WHERE empID = 8");

            System.out.println("Record deleted. Rows affected: " + delete);

            System.out.println("Employee Table after Deletion ");
            rs = stmt.executeQuery("SELECT * FROM employee");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("empID") + "\t" +
                                rs.getString("empName") + "\t" +
                                rs.getString("empRole") + "\t" +
                                rs.getInt("empSalary")
                );
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

/*1. Import sqp package
* 2. Load Java driver
* 3. Establish connection
* 4. Create statement
* 5. Queries  */