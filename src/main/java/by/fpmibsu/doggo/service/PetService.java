package by.fpmibsu.doggo.service;

import by.fpmibsu.doggo.entity.Pet;
import by.fpmibsu.doggo.entity.User;
import by.fpmibsu.doggo.service.exception.ServiceException;

import java.util.List;

public interface PetService {

    public void createPet(Pet pet) throws ServiceException;
    public Pet findById(int petId) throws ServiceException ;

    public List<Pet> userPets(User user) throws ServiceException ;
}
