package by.epam.service;

import by.epam.dao.IFlightDao;
import by.epam.dao.IOrderDao;
import by.epam.dao.impl.FlightDao;
import by.epam.dao.impl.OrderDao;
import by.epam.entity.*;
import by.epam.exceptions.DaoException;
import by.epam.exceptions.ServiceException;
import by.epam.utils.ConstantsJSP;
import org.apache.logging.log4j.LogManager;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class OrderService {
    private static final java.util.logging.Logger logger = Logger.getLogger(OrderService.class.getName());

    public static void createOrder(User user, Flight flight, int amountForOrder) throws ServiceException {
        try {
            IOrderDao orderDao = new OrderDao();
            int totalCost = flight.getPrice() * amountForOrder;
            Order order = new Order(user.getId(), flight.getId(), amountForOrder, totalCost);
            orderDao.create(order);
        } catch (DaoException e) {
            logger.warning("Unable to create order!");
            throw new ServiceException(e.getMessage());
        }
    }

    public static void setOrderInfoByAll(HttpSession session) throws ServiceException { //!!!!!!!!!!!!!
        try {
            IOrderDao orderDao = new OrderDao();
            List<Order> orders = orderDao.findAll(ConstantsJSP.LIMIT, ConstantsJSP.OFFSET);
            createOrderInfo(session, orders);
        } catch (DaoException e) {
            logger.warning("Unable to set orderInfo!");
            throw new ServiceException(e.getMessage());
        }
    }

    public static void setOrderInfoByUserId(HttpSession session, User user) throws ServiceException { //!!!!!!!!!!!!!
        try {
            IOrderDao orderDao = new OrderDao();
            session.setAttribute(ConstantsJSP.USER, user);
            List<Order> orders = orderDao.findByUserId(user.getId());
            createOrderInfo(session, orders);
        } catch (DaoException e) {
            logger.warning("Unable to set orderInfo!");
            throw new ServiceException(e.getMessage());
        }
    }

    private static void createOrderInfo(HttpSession session, List<Order> orders) throws ServiceException { //!!!!!!!!!!!
        try {
            IFlightDao flightDao = new FlightDao();
            List<OrderInfo> infos = new ArrayList<>();
            for (Order ord : orders) {
                System.out.println(ord);
                Optional<Flight> optionalFlight = flightDao.findById(ord.getFlightId());
                System.out.println(optionalFlight.get());
                ord.setTotalCost(calculateTotalCost(ord));
                System.out.println("+++");
                optionalFlight.ifPresent(value -> infos.add(new OrderInfo(ord, value)));
            }
            for(OrderInfo inf: infos){
                System.out.println(inf);
            }
            session.setAttribute(ConstantsJSP.ORDERS, infos);
        } catch (DaoException e) {
            logger.warning("Unable to create orderInfo!");
            throw new ServiceException(e.getMessage());
        }
    }

    public static void deleteOrder(long flightId) throws ServiceException {
        try {
            IOrderDao orderDao = new OrderDao();
            List<Order> orders = orderDao.findByFlightId(flightId);
            if (!orders.isEmpty()) {
                for (Order order : orders) {
                    orderDao.delete(order.getId());
                }
            }
        } catch (DaoException e) {
            logger.warning("Unable to delete orders!");
            throw new ServiceException(e.getMessage());
        }
    }

    public static int calculateTotalCost(Order order) throws ServiceException {
        try {
            IFlightDao flightDao = new FlightDao();
            int totalCost = 0;
            Optional<Flight> optionalFlight = flightDao.findById(order.getFlightId());
            if (optionalFlight.isPresent()) {
                totalCost = optionalFlight.get().getPrice() * order.getAmount();
            }
            return totalCost;
        } catch (DaoException e) {
            logger.warning("Unable to calculate total cost!");
            throw new ServiceException(e.getMessage());
        }
    }
}
