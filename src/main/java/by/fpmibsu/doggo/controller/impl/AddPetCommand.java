package by.fpmibsu.doggo.controller.impl;

import by.fpmibsu.doggo.controller.Command;
import by.fpmibsu.doggo.controller.constants.CommandName;
import by.fpmibsu.doggo.controller.constants.ParameterName;
import by.fpmibsu.doggo.entity.Pet;
import by.fpmibsu.doggo.entity.User;
import by.fpmibsu.doggo.entity.enums.Breed;
import by.fpmibsu.doggo.service.FactoryService;
import by.fpmibsu.doggo.service.PetService;
import by.fpmibsu.doggo.service.UserService;
import by.fpmibsu.doggo.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddPetCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String name = request.getParameter(ParameterName.NAME);
        Integer age = Integer.valueOf(request.getParameter(ParameterName.AGE));
        Breed breed = Breed.valueOf(request.getParameter(ParameterName.BREED));
        Double weight = Double.valueOf(request.getParameter(ParameterName.WEIGHT));
        HttpSession session = request.getSession();

        UserService userService = FactoryService.getInstance().getUserService();
        PetService petService = FactoryService.getInstance().getPetService();

        Pet pet = new Pet();
        pet.setName(name);
        pet.setAge(age);
        pet.setBreed(breed);
        pet.setWeight(weight);
        User owner;

        String ownerUsername = (String) session.getAttribute(ParameterName.USERNAME);
        try {
            owner = userService.findByUsername(ownerUsername);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

        pet.setOwner(owner);

        try {
            petService.createPet(pet);
            response.sendRedirect(CommandName.MAIN_PAGE);
        } catch (ServiceException e) {
            //response.sendRedirect(CommandName.ERROR_PAGE);
        }
    }
}
