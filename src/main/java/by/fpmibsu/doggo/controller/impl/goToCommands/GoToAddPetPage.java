package by.fpmibsu.doggo.controller.impl.goToCommands;

import by.fpmibsu.doggo.controller.Command;
import by.fpmibsu.doggo.controller.constants.PagePath;
import by.fpmibsu.doggo.controller.constants.ParameterName;
import by.fpmibsu.doggo.entity.enums.Breed;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GoToAddPetPage implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        List<Breed> breeds = Arrays.asList(Breed.values());
        HttpSession session = request.getSession();

        session.setAttribute(ParameterName.BREEDS,breeds);
        RequestDispatcher dispatcher = request.getRequestDispatcher(PagePath.ADD_PET_PAGE);
        dispatcher.forward(request, response);

    }
}
