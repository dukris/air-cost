package by.epam.command;

import by.epam.command.transmission.CommandResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICommand {

    /**
     * Method that is executed by the controller when a specific command is called
     *
     * @param req HttpServletRequest
     * @param resp HttpServletResponse
     * @return CommandResult of page with routing type
     */
    CommandResult execute(HttpServletRequest req, HttpServletResponse resp);
}
