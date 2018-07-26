
public class PostgreSQLJDBC {
    public static void main(String args[]) {

        CreateTable create = new CreateTable();
        InsertTable insert = new InsertTable();
        SelectTable select = new SelectTable();
        UpdateTable update = new UpdateTable();
        DeleteTable delete = new DeleteTable();

        create.createTableRun();
        insert.insertTableRun();
        select.selectTableRun();
        update.updateTableRun();
        delete.deleteTableRun();
    }
}