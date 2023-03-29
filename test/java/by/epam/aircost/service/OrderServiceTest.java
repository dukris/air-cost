package by.epam.aircost.service;

import by.epam.dao.connection.impl.ConnectionPool;
import by.epam.entity.Order;
import by.epam.exceptions.ConnectionException;
import by.epam.exceptions.ServiceException;
import by.epam.service.OrderService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.Assert.*;

public class OrderServiceTest {

    @BeforeAll
    static void initializeConnectionPool() throws ConnectionException {
        ConnectionPool.getInstance().initialize();
    }

    @Test
    public void testCalculateTotalCost() throws ServiceException {
        int actual = OrderService.calculateTotalCost(new Order(0, 2, 1, 0));
        int expected = 185;
        assertEquals(actual, expected);
    }
}
