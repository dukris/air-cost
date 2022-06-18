package by.epam.dao;

import by.epam.exceptions.DaoException;

import java.util.List;
import java.util.Optional;

public interface IDao<T> {

    /**
     * Method for getting a list of entities
     *
     * @param limit number of rows in the sample
     * @param offset offset relative to the beginning of the resulting list
     * @return list of entities
     * @throws DaoException
     */
    List<T> findAll(int limit, int offset) throws DaoException;

    /**
     * Method for getting entity by id
     *
     * @param id id of entity
     * @return optional entity object
     * @throws DaoException
     */
    Optional<T> findById(long id) throws DaoException;

    /**
     * Method for deleting entity by id
     *
     * @param id id of entity
     * @throws DaoException
     */
    void delete(long id) throws DaoException;

    /**
     * Method for saving entity by id
     *
     * @param entity entity to save
     * @throws DaoException
     */
    void create(T entity) throws DaoException;

    /**
     * Method for updating entity by id
     *
     * @param entity entity to update
     * @throws DaoException
     */
    void update(T entity) throws DaoException;
}
