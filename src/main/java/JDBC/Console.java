package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Console {
    private static void menu(Connection connection, WorkerCRUD workerCRUD) throws SQLException {
        String nothing;
        System.out.println("select [1-5]");
        System.out.println("//================================");
        System.out.println("1. show all workers");
        System.out.println("2. add new worker");
        System.out.println("3. show specific worker");
        System.out.println("4. edit specific worker");
        System.out.println("5. delete specific worker");
        System.out.println("6. show bonus");
        System.out.println("7. out program.");
        System.out.println("//================================");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1:
                workerCRUD.read(connection);
                sc.next();
                menu(connection, workerCRUD);
                break;
            case 2:
                workerCRUD.create(connection);
                sc.next();
                menu(connection, workerCRUD);
                break;
            case 3:
                System.out.println("enter the worker id:");
                int id = sc.nextInt();
                workerCRUD.isWorkerExist(connection, id);
                sc.next();
                menu(connection, workerCRUD);
                break;
            case 4:
                workerCRUD.update(connection);
                sc.next();
                menu(connection, workerCRUD);
                break;
            case 5:
                workerCRUD.delete(connection);
                sc.next();
                menu(connection, workerCRUD);
                break;
            case 6:
                workerCRUD.other(connection);
                sc.next();
                menu(connection,workerCRUD);
                break;
            case 7:
                System.exit(0);
                break;

            default:
                System.out.println("wrong input");
                sc.next();
                menu(connection, workerCRUD);
        }
    }

    public static void main(String[] args) throws SQLException {
        JDBC db = new JDBC();
        WorkerCRUD workerCRUD = new WorkerCRUD();
        Connection conn = db.getConnection();

        menu(conn,workerCRUD);
        workerCRUD.closeStm();
        db.closeConnection();
    }
}
