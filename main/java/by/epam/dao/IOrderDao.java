package by.epam.dao;

import by.epam.entity.Order;
import by.epam.exceptions.DaoException;

import java.util.List;

public interface IOrderDao extends IDao<Order> {

    /**
     * Method for getting a list of orders by user's id
     *
     * @param userId user's id
     * @return list of orders
     * @throws DaoException
     */
    List<Order> findByUserId(long userId) throws DaoException;

    /**
     * Method for getting a list of orders by flight's id
     *
     * @param flightId flight's id
     * @return list of orders
     * @throws DaoException
     */
    List<Order> findByFlightId(long flightId) throws DaoException;
}

