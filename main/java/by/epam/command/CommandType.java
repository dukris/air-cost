package by.epam.command;

import by.epam.command.impl.*;
import by.epam.command.impl.page.*;

public enum CommandType {
    LOGIN_PAGE(new LoginPageCommand()),
    REGISTER_PAGE(new RegisterPageCommand()),
    LOGIN(new LoginCommand()),
    REGISTER(new RegisterCommand()),
    HOME_PAGE(new HomePageCommand()),
    HOME(new HomeCommand()),
    ERROR(new ErrorPageCommand()),
    UPDATE_PROFILE_PAGE(new UpdateProfilePageCommand()),
    LOGOUT_PAGE(new LogoutPageCommand()),
    LOGOUT(new LogoutCommand()),
    PROFILE_PAGE(new ProfilePageCommand()),
    EDIT_FLIGHT(new EditFlightCommand()),
    ADD_PAGE(new AddFlightPageCommand()),
    ADD(new AddFlightCommand()),
    UPDATE_FLIGHT(new UpdateFlightCommand()),
    SUBMIT_ORDER(new SubmitOrderCommand()),
    RESERVE_FLIGHT(new ReserveFlightCommand()),
    LANGUAGE(new LanguageCommand()),
    UPDATE_PROFILE(new UpdateProfileCommand());

    private ICommand command;

    CommandType(ICommand command) {
        this.command = command;
    }

    public ICommand getCommand() {
        return command;
    }
}
