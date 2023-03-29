package by.epam.dao;

import by.epam.entity.Flight;
import by.epam.exceptions.DaoException;

import java.util.List;

public interface IFlightDao extends IDao<Flight> {

    /**
     * Method for getting a list of entities by parameters
     *
     * @param from departure city
     * @param to arrival city
     * @param date flight date
     * @return list of flights
     * @throws DaoException
     */
    List<Flight> findByParameters(String from, String to, String date) throws DaoException;

    /**
     * Method for getting a list of cities (in English)
     *
     * @param limit number of rows in the sample
     * @param offset offset relative to the beginning of the resulting list
     * @return list of cities
     * @throws DaoException
     */
    List<String> findCitiesEn(int limit, int offset) throws DaoException;

    /**
     * Method for getting a list of cities (in Russian)
     *
     * @param limit number of rows in the sample
     * @param offset offset relative to the beginning of the resulting list
     * @return list of cities
     * @throws DaoException
     */
    List<String> findCitiesRu(int limit, int offset) throws DaoException;
}
