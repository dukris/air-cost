package by.epam.service;

import by.epam.dao.IFlightDao;
import by.epam.dao.impl.FlightDao;
import by.epam.entity.Flight;
import by.epam.exceptions.DaoException;
import by.epam.exceptions.ServiceException;
import by.epam.utils.ConstantsJSP;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class FlightService {
    private static final java.util.logging.Logger logger = Logger.getLogger(FlightService.class.getName());

    public static void addFlight(HttpSession session, String from, String to, String date, int amount, int price) throws ServiceException {
        try {
            IFlightDao flightDao = new FlightDao();
            Flight flight = new Flight(from, to, date, amount, price);
            flightDao.create(flight);
            session.setAttribute(ConstantsJSP.FLIGHTS, flightDao.findAll(ConstantsJSP.LIMIT, ConstantsJSP.OFFSET));
        } catch (DaoException e) {
            logger.warning("Unable to add flight!");
            throw new ServiceException(e.getMessage());
        }
    }

    public static void updateFlight(HttpSession session, String from, String to, String date, int amount, int price) throws ServiceException {
        try {
            IFlightDao flightDao = new FlightDao();
            Flight flight = (Flight) session.getAttribute(ConstantsJSP.EDIT_FLIGHT);
            flight.setFromCity(from);
            flight.setToCity(to);
            flight.setDate(date);
            flight.setAmount(amount);
            flight.setPrice(price);
            flightDao.update(flight);
            session.setAttribute(ConstantsJSP.FLIGHTS, flightDao.findAll(ConstantsJSP.LIMIT, ConstantsJSP.OFFSET));
        } catch (DaoException e) {
            logger.warning("Unable to edit flight!");
            throw new ServiceException(e.getMessage());
        }
    }
    public static boolean checkDate(String date) throws ServiceException {
        try{
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            Date parsingDate = ft.parse(date);
            return parsingDate.after(new Date());
        }catch (ParseException e){
            logger.warning("Unable to check the date!");
            throw new ServiceException(e.getMessage());
        }
    }

    public static void updateFlight(Flight flight, int amountForOrder) throws ServiceException {
        try {
            IFlightDao flightDao = new FlightDao();
            flight.setAmount((flight.getAmount() - amountForOrder));
            System.out.println(flight.getAmount() - amountForOrder);
            flightDao.update(flight);
        } catch (DaoException e) {
            logger.warning("Unable to edit flight!");
            throw new ServiceException(e.getMessage());
        }
    }

    public static List<Flight> findFlights(String from, String to, String date) throws ServiceException {
        try {
            IFlightDao flightDao = new FlightDao();
            return flightDao.findByParameters(from, to, date);
        } catch (DaoException e) {
            logger.warning("Unable to find flights!");
            throw new ServiceException(e.getMessage());
        }
    }

    public static void reserveFlight(HttpSession session, long id) throws ServiceException {
        try {
            IFlightDao flightDao = new FlightDao();
            Optional<Flight> optionalFlight = flightDao.findById(id);
            optionalFlight.ifPresent(flight -> session.setAttribute(ConstantsJSP.ORDER, flight));
        } catch (DaoException e) {
            logger.warning("Unable to reserve flight!");
            throw new ServiceException(e.getMessage());
        }
    }

    public static void editFlight(HttpSession session, String editChoice) throws ServiceException {
        try {
            IFlightDao flightDao = new FlightDao();
            Optional<Flight> optionalFlight = flightDao.findById(Long.parseLong(editChoice));
            optionalFlight.ifPresent(flight -> session.setAttribute(ConstantsJSP.EDIT_FLIGHT, flight));
        } catch (DaoException e) {
            logger.warning("Unable to edit flight!");
            throw new ServiceException(e.getMessage());
        }
    }

    public static void deleteFlight(HttpSession session, String deleteChoice) throws ServiceException {
        try {
            IFlightDao flightDao = new FlightDao();
            OrderService.deleteOrder(Long.parseLong(deleteChoice));
            flightDao.delete(Long.parseLong(deleteChoice));
            session.setAttribute(ConstantsJSP.FLIGHTS, flightDao.findAll(ConstantsJSP.LIMIT, ConstantsJSP.OFFSET));
        } catch (DaoException e) {
            logger.warning("Unable to delete flight!");
            throw new ServiceException(e.getMessage());
        }
    }
}
