package by.epam.dao;

import by.epam.entity.User;
import by.epam.exceptions.DaoException;

import java.util.Optional;

public interface IUserDao extends IDao<User> {

    /**
     * Method for getting a list of orders by user's id
     *
     * @param email user's email
     * @return optional user
     * @throws DaoException
     */
    Optional<User> findByEmail(String email) throws DaoException;

    /**
     * Method for getting a list of orders by user's id
     *
     * @param email user's email
     * @return encoded password
     * @throws DaoException
     */
    String getEncodedPassword(String email) throws DaoException;
}
