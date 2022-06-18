package by.epam.aircost.dao.connection;

import by.epam.dao.connection.impl.ConnectionPool;
import by.epam.exceptions.ConnectionException;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;


import static org.junit.Assert.assertEquals;

public class ConnectionPoolTest {

    @BeforeAll
    static void initializeConnectionPool() throws ConnectionException {
        ConnectionPool.getInstance().initialize();
    }

    @Test
    public void testGetInstance() {
        ConnectionPool poolFirst = ConnectionPool.getInstance();
        ConnectionPool poolSecond = ConnectionPool.getInstance();
        assertEquals(poolFirst, poolSecond);
    }
}