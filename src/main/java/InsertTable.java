import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertTable {

    public void insertTableRun() {
        Connection c;
        Statement stmt;
        try {
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testconnectiondb", "postgres", "123");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY,DATE) "
                    + "VALUES (1, 'Zeke Elliot', 25, 'Salt Lake City', 2000000.00, CURRENT_DATE );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY,DATE) "
                    + "VALUES (2, 'William Murray', 65, 'Draper', 150000.00, CURRENT_DATE );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY,DATE) "
                    + "VALUES (3, 'The Dude', 55, 'Bountiful', 20000.00, CURRENT_DATE );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY,DATE) "
                    + "VALUES (4, 'Thomas Shelby', 32, 'Stanbury Park ', 75000.00, CURRENT_DATE );";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Creating records...");

    }
}
