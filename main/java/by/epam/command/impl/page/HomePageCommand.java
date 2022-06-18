package by.epam.command.impl.page;

import by.epam.command.transmission.CommandResult;
import by.epam.command.transmission.ForwardCommandResult;
import by.epam.command.ICommand;
import by.epam.entity.RoleType;
import by.epam.entity.User;
import by.epam.utils.ConstantsJSP;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomePageCommand implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        return session.getAttribute(ConstantsJSP.USER) != null
                && ((User) session.getAttribute(ConstantsJSP.USER)).getRoleType() == RoleType.ADMIN
                || session.getAttribute(ConstantsJSP.USER) == null ?
                new ForwardCommandResult(ConstantsJSP.PROFILE_PAGE_URL) :
                new ForwardCommandResult(ConstantsJSP.HOME_PAGE_URL);
    }
}
