package JDBC;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * The interface Icrud.
 */
public interface Icrud {
    /**
     * Create.
     *
     * @param connection the connection
     * @throws SQLException the sql exception
     */
    void create(Connection connection)throws SQLException;

    /**
     * Read.
     *
     * @param connection the connection
     * @throws SQLException the sql exception
     */
    void read(Connection connection)throws SQLException;

    /**
     * Update.
     *
     * @param connection the connection
     * @throws SQLException the sql exception
     */
    void update(Connection connection)throws SQLException;

    /**
     * Delete.
     *
     * @param connection the connection
     * @throws SQLException the sql exception
     */
    void delete(Connection connection)throws SQLException;

    void other(Connection connection)throws SQLException;

    /**
     * Is worker exist boolean.
     *
     * @param connection the connection
     * @param workerId   the worker id
     * @return the boolean
     * @throws SQLException the sql exception
     */
    boolean isWorkerExist(Connection connection, int workerId)throws SQLException;
}
