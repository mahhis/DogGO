package by.fpmibsu.doggo.dao.builder;

import by.fpmibsu.doggo.dao.FactoryDAO;
import by.fpmibsu.doggo.dao.UserDAO;
import by.fpmibsu.doggo.dao.exception.DAOException;
import by.fpmibsu.doggo.entity.Pet;
import by.fpmibsu.doggo.entity.enums.Breed;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PetBuilder {
    private static final UserDAO userDAO = FactoryDAO.getInstance().getUserDAO();
    public Pet buildPet(ResultSet resultSet) throws SQLException, DAOException {
        Pet pet = new Pet();
        build(pet, resultSet);
        return pet;
    }

    private void build(Pet pet, ResultSet resultSet) throws SQLException, DAOException {

        pet.setOwner(userDAO.findById(resultSet.getInt("user_id")));
        pet.setName(resultSet.getString("pet_name"));
        pet.setAge(resultSet.getInt("age"));
        pet.setBreed(Breed.valueOf(resultSet.getString("breed")));
        pet.setWeight(resultSet.getDouble("weight"));

    }
}
