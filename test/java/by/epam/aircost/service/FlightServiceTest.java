package by.epam.aircost.service;

import by.epam.dao.connection.impl.ConnectionPool;
import by.epam.exceptions.ConnectionException;
import by.epam.exceptions.ServiceException;
import by.epam.service.FlightService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FlightServiceTest {

    @BeforeAll
    static void initializeConnectionPool() throws ConnectionException {
        ConnectionPool.getInstance().initialize();
    }

    @Test
    public void testCheckDateTrue() throws ServiceException {
        boolean actual = FlightService.checkDate("2022-07-20");
        assertTrue(actual);
    }

    @Test
    public void testCheckDateFalse() throws ServiceException {
        boolean actual = FlightService.checkDate("2022-04-20");
        assertFalse(actual);
    }
}
