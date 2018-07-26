import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteTable {

    public void deleteTableRun() {
        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testconnectiondb", "postgres", "123");

            stmt = c.createStatement();
            String sql = "DROP TABLE COMPANY";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table deleted successfully");
    }
}
