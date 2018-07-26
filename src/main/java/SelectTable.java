import java.sql.*;
import java.text.NumberFormat;

public class SelectTable {

    public void selectTableRun() {
        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testconnectiondb", "postgres", "123");
            c.setAutoCommit(false);
            System.out.println("Selecting records...\n");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY;");
            dataInTable(rs);
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }
    static void dataInTable(ResultSet rs) throws SQLException {
        while (rs.next()) {
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String address = rs.getString("address");
            float salary = rs.getFloat("salary");
            Date date = rs.getDate("date");
            System.out.println("ID = " + id);
            System.out.println("NAME = " + name);
            System.out.println("AGE = " + age);
            System.out.println("ADDRESS = " + address);
            System.out.println("SALARY = " + formatter.format(salary));
            System.out.println("DATE = " + date);
            System.out.println();
        }
    }
}
