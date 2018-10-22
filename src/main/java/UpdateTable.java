import java.sql.*;

public class UpdateTable {

    public void updateTableRun() {
        Connection c;
        Statement stmt;
        try {
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testconnectiondb", "postgres", "123");

            c.setAutoCommit(false);
            System.out.println("Updating record...");

            stmt = c.createStatement();
            String sql = "UPDATE COMPANY set SALARY = 2500000.00 where ID=1;";
            stmt.executeUpdate(sql);
            c.commit();

            ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY WHERE SALARY = 2500000.00;");
            SelectTable.dataInTable(rs);
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
