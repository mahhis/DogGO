package by.fpmibsu.doggo.dao;

import by.fpmibsu.doggo.dao.exception.DAOException;
import by.fpmibsu.doggo.entity.Pet;
import by.fpmibsu.doggo.entity.User;

import java.util.List;

public interface PetDAO {

    public void createPet(Pet pet) throws DAOException;
    public Pet findById(int petId) throws DAOException ;

    public List<Pet> userPets(User user) throws DAOException ;
}
