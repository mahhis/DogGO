package by.fpmibsu.doggo.controller.impl.goToCommands;

import by.fpmibsu.doggo.controller.Command;
import by.fpmibsu.doggo.controller.constants.PagePath;
import by.fpmibsu.doggo.controller.constants.ParameterName;
import by.fpmibsu.doggo.entity.Pet;
import by.fpmibsu.doggo.service.FactoryService;
import by.fpmibsu.doggo.service.PetService;
import by.fpmibsu.doggo.service.UserService;
import by.fpmibsu.doggo.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GoToOrderPage implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PetService petService = FactoryService.getInstance().getPetService();
        UserService userService = FactoryService.getInstance().getUserService();
        HttpSession session = request.getSession();

        String ownerUsername = (String) session.getAttribute(ParameterName.USERNAME);
        List<Pet> pets =null;
        try {
           pets = petService.userPets(userService.findByUsername(ownerUsername));
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

        session.setAttribute(ParameterName.PETS,pets);
        RequestDispatcher dispatcher = request.getRequestDispatcher(PagePath.ORDER_PAGE);
        dispatcher.forward(request, response);
    }
}
