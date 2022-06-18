package by.epam.aircost.dao.impl;

import by.epam.dao.IFlightDao;
import by.epam.dao.connection.impl.ConnectionPool;
import by.epam.dao.impl.FlightDao;
import by.epam.entity.Flight;
import by.epam.exceptions.ConnectionException;
import by.epam.exceptions.DaoException;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class FlightDaoTest {

    IFlightDao flightDao = new FlightDao();

    @BeforeAll
    public static void initializeConnectionPool() throws ConnectionException {
        ConnectionPool.getInstance().initialize();
    }

    @Test
    public void testFindById() throws DaoException {
        Optional<Flight> actual = flightDao.findById(2);
        Flight expected = new Flight();
        expected.setId(2);
        expected.setFromCity("Москва");
        expected.setToCity("Минск");
        expected.setDate("2022-05-08");
        expected.setAmount(17);
        expected.setPrice(185);
        assertEquals(expected, actual.get());
    }
}
