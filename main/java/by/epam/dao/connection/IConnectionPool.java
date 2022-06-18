package by.epam.dao.connection;

import by.epam.exceptions.ConnectionException;

import java.sql.Connection;

public interface IConnectionPool {

    /**
     * Method for getting connection
     *
     * @return object of connection
     * @throws ConnectionException
     */
    Connection getConnection() throws ConnectionException;

    /**
     * Method to initialize the connection
     *
     * @throws ConnectionException
     */
    void initialize() throws ConnectionException;

    /**
     * Method to release the connection
     *
     * @param connection object of connection
     * @throws ConnectionException
     */
    void releaseConnection(Connection connection) throws ConnectionException;

    /**
     * Method to destroy the connection
     *
     * @throws ConnectionException
     */
    void destroy() throws ConnectionException;
}
