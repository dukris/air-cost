package by.epam.command.impl.page;

import by.epam.command.transmission.CommandResult;
import by.epam.command.transmission.ForwardCommandResult;
import by.epam.command.ICommand;
import by.epam.utils.ConstantsJSP;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutPageCommand implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) {
        return new ForwardCommandResult(ConstantsJSP.START_PAGE_URL);
    }
}
