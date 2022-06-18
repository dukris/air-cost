package by.epam.command.impl;

import by.epam.command.transmission.CommandResult;
import by.epam.command.transmission.ErrorCommandResult;
import by.epam.command.transmission.ForwardCommandResult;
import by.epam.command.ICommand;
import by.epam.command.transmission.RedirectCommandResult;
import by.epam.entity.Flight;
import by.epam.entity.User;
import by.epam.exceptions.ServiceException;
import by.epam.service.FlightService;
import by.epam.service.OrderService;
import by.epam.utils.ConstantsJSP;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SubmitOrderCommand implements ICommand {
    private static final Logger logger = LogManager.getLogger(SubmitOrderCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute(ConstantsJSP.USER);
            Flight flight = (Flight) session.getAttribute(ConstantsJSP.ORDER);
            int amountForOrder = Integer.parseInt(req.getParameter(ConstantsJSP.AMOUNT));
            if (amountForOrder <= 0 || amountForOrder>flight.getAmount()) {
                req.setAttribute(ConstantsJSP.ERROR_NAME, ConstantsJSP.FIRST_ERROR_CODE);
                return new ForwardCommandResult(ConstantsJSP.RESERVE_PAGE_URL);
            }
            System.out.println("***");
            OrderService.createOrder(user, flight, amountForOrder);
            System.out.println("create order");
            FlightService.updateFlight(flight, amountForOrder);
            System.out.println("update flight");
            OrderService.setOrderInfoByAll(session);
            System.out.println("set info");
            return new RedirectCommandResult(ConstantsJSP.AIRCOST_URL + ConstantsJSP.PROFILE_PAGE_URL);
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            return new ErrorCommandResult();
        }
    }
}


