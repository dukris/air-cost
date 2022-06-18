package by.epam.aircost.dao.impl;

import by.epam.dao.IFlightDao;
import by.epam.dao.IOrderDao;
import by.epam.dao.connection.impl.ConnectionPool;
import by.epam.dao.impl.FlightDao;
import by.epam.dao.impl.OrderDao;
import by.epam.entity.Flight;
import by.epam.entity.Order;
import by.epam.exceptions.ConnectionException;
import by.epam.exceptions.DaoException;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class OrderDaoTest {
    IOrderDao orderDao = new OrderDao();

    @BeforeAll
    public static void initializeConnectionPool() throws ConnectionException {
        ConnectionPool.getInstance().initialize();
    }

    @Test
    public void testFindById() throws DaoException {
        Optional<Order> actual = orderDao.findById(17);
        Order expected = new Order();
        expected.setId(17);
        expected.setUserId(2);
        expected.setFlightId(3);
        expected.setAmount(1);
        expected.setTotalCost(215);
        assertEquals(expected, actual.get());
    }
}
