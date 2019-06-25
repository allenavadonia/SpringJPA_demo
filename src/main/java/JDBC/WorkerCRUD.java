package JDBC;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * The type Worker crud.
 */
public class WorkerCRUD implements Icrud {


    private PreparedStatement stm = null;
    private String sql = null;

    @Override
    public void create(Connection conn) throws SQLException {
        String fn, ln, department;
        LocalDateTime joiningDate;
        double salary;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter new worker:");
        System.out.print("First name: ");
        fn = sc.nextLine();
        System.out.println();
        System.out.print("Last name: ");
        ln = sc.nextLine();
        System.out.println();
        joiningDate = LocalDateTime.now();
        System.out.print("Department: ");
        department = sc.nextLine();
        System.out.println();
        System.out.print("Salary: ");
        salary = sc.nextDouble();


        sql = "insert into worker(firstname, lastname, salary, joining_date, department)" +
                " value (?,?,?,?,?)";
        stm = conn.prepareStatement(sql);
        stm.setString(1, fn);
        stm.setString(2, ln);
        stm.setDouble(3, salary);
        stm.setTimestamp(4, Timestamp.valueOf(joiningDate));
        stm.setString(5, department);

        stm.execute();
    }

    @Override
    public void read(Connection connection) throws SQLException {
        sql = "select * from worker";
        stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        System.out.println("//=====================================================");
        while (rs.next()) {
            System.out.print(rs.getInt("worker_id"));
            System.out.print("\t" + rs.getString("firstname"));
            System.out.print("\t\t" + rs.getString("lastname"));
            System.out.print("\t\t" + rs.getDouble("salary"));
            System.out.print("\t" + rs.getTimestamp("joining_date"));
            System.out.println("\t" + rs.getString("department"));
        }
        System.out.println("//=====================================================");

    }

    @Override
    public void update(Connection connection) throws SQLException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        Scanner sc = new Scanner(System.in);
        String fn, ln, department;
        LocalDateTime joiningDate;
        double salary;
        read(connection);
        System.out.print("enter the worker id that needed to update: ");
        int updateId = sc.nextInt();
        System.out.println("//=================================");
        if (isWorkerExist(connection, updateId)) {
            sc = new Scanner(System.in);
            System.out.println("editing..");
            System.out.print("First name: ");
            fn = sc.nextLine();
            System.out.println();
            System.out.print("Last name: ");
            ln = sc.nextLine();
            System.out.println();
            System.out.print("Joining date(yyyy/MM/dd HH:mm:ss): ");
            joiningDate = LocalDateTime.parse(sc.nextLine(),dateTimeFormatter);
            System.out.println();
            System.out.print("Department: ");
            department = sc.nextLine();
            System.out.println();
            System.out.print("Salary: ");
            salary = sc.nextDouble();

            sql = "update worker set " +
                    "firstname = ?," +
                    "lastname = ?," +
                    "salary = ?," +
                    "joining_date = ?,"+
                    "department = ?"+
                    "where worker_id = ?";
            stm= connection.prepareStatement(sql);
            stm.setString(1,fn);
            stm.setString(2, ln);
            stm.setDouble(3, salary);
            stm.setTimestamp(4, Timestamp.valueOf(joiningDate));
            stm.setString(5, department);
            stm.setInt(6,updateId);

            stm.execute();
        } else
            System.out.println("worker id does NOT exist!");
    }

    @Override
    public void delete(Connection connection) throws SQLException {
        Scanner sc = new Scanner(System.in);
        read(connection);
        System.out.print("enter the worker id that needed delete: ");
        int delId = sc.nextInt();
        if (isWorkerExist(connection, delId)) {
            sql = "delete from worker where worker_id = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, delId);
            stm.execute();
        } else System.out.println("worker id does NOT exist!");
    }

    @Override
    public void other(Connection connection) throws SQLException{
        Scanner sc = new Scanner(System.in);
        read(connection);
        System.out.println("enter the worker id that needed to see bonuses: ");
        int workId=sc.nextInt();
        if (isWorkerExist(connection,workId)){
            sql="select * from bonus where worker_ref_id = ?";
            stm=connection.prepareStatement(sql);
            stm.setInt(1,workId);
            ResultSet resultSet=stm.executeQuery();
            System.out.println("//==================================");
            System.out.println("bonusID\tworkerID\t\tDate\tAmount");
            while (resultSet.next()){
                System.out.print(resultSet.getInt("bonus_id"));
                System.out.print("\t\t\t"+resultSet.getInt("worker_ref_id"));
                System.out.print("\t\t\t"+resultSet.getDate("bonus_date"));
                System.out.println("\t"+resultSet.getDouble("bonus_amount"));
            }


        } else System.out.println("worker id does NOT exist!");
    }

    @Override
    public boolean isWorkerExist(Connection connection, int workerId) throws SQLException {
        sql = "select * from worker where worker_id = ?";
        stm = connection.prepareStatement(sql);
        stm.setInt(1, workerId);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            System.out.print(rs.getInt("worker_id"));
            System.out.print("\t" + rs.getString("firstname"));
            System.out.print("\t" + rs.getString("lastname"));
            System.out.print("\t" + rs.getDouble("salary"));
            System.out.print("\t" + rs.getTimestamp("joining_date"));
            System.out.println("\t" + rs.getString("department"));
            return true;
        }
        return false;
    }

    /**
     * Close stm.
     *
     * @throws SQLException the sql exception
     */
    public void closeStm () throws SQLException {
        if (stm!=null){
            stm.close();

        }
    }
}
