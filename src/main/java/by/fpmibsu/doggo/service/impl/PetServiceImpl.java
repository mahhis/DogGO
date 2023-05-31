package by.fpmibsu.doggo.service.impl;

import by.fpmibsu.doggo.dao.FactoryDAO;
import by.fpmibsu.doggo.dao.PetDAO;
import by.fpmibsu.doggo.dao.exception.DAOException;
import by.fpmibsu.doggo.entity.Pet;
import by.fpmibsu.doggo.entity.User;
import by.fpmibsu.doggo.service.PetService;
import by.fpmibsu.doggo.service.exception.ServiceException;

import java.util.List;

public class PetServiceImpl implements PetService {

    private static final PetDAO petDAO = FactoryDAO.getInstance().getPetDAO();
    @Override
    public void createPet(Pet pet) throws ServiceException {
        try {
            petDAO.createPet(pet);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Pet findById(int petId) throws ServiceException {
        Pet pet = null;
        try {
            pet = petDAO.findById(petId);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }


        return pet;
    }

    @Override
    public List<Pet> userPets(User user) throws ServiceException {
        List<Pet> pets;
        try {
            pets=petDAO.userPets(user);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
        return pets;
    }
}
