package JDBC;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.sql.*;

public class JDBC {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/testWorker";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "Triti105567";
    static private Connection conn = null;


    public Connection getConnection() {

        try {
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public void closeConnection() {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
            System.out.println("close Connect error");
            se.printStackTrace();
        }

    }

   /* public static void main(String[] args) throws SQLException {
        JDBC j = new JDBC();
        Statement stmt = null;
        Connection conn = null;
        try {
            conn = j.getConnection();
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM worker";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int work_id = rs.getInt("worker_id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                double salary = rs.getDouble("salary");
                String joining_date = String.valueOf(rs.getDate("joining_date"));
                String department = rs.getString("department");


                //Display values
                System.out.print("ID: " + work_id);
                System.out.print(", first name: " + firstname);
                System.out.print(", last name: " + lastname);
                System.out.print(",  salary: " + salary);
                System.out.print(", joing date: " + joining_date);
                System.out.println(", department: " + department);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                // nothing we can do
            }
            j.closeConnection();
        }//end try
        System.out.println("Goodbye!");
    }//end main*/
}
