package by.fpmibsu.doggo.dao.impl;

import by.fpmibsu.doggo.dao.PetDAO;
import by.fpmibsu.doggo.dao.builder.BuilderFactory;
import by.fpmibsu.doggo.dao.database.ConnectionPool;
import by.fpmibsu.doggo.dao.database.ConnectionPoolException;
import by.fpmibsu.doggo.dao.exception.DAOException;
import by.fpmibsu.doggo.entity.Pet;
import by.fpmibsu.doggo.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetDAOImpl implements PetDAO {

    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String FIND_PET_BY_ID = "SELECT * FROM pet WHERE pet_id = ?";
    private static final String FIND_ALL_PETS_BY_WALKER_ID = "SELECT * FROM pet WHERE user_id = ?";

    private static final String CREATE_NEW_PET = "INSERT INTO  pet (user_id, pet_name, age, breed, weight) VALUES (?, ?, ?, ?, ?);";





    @Override
    public void createPet(Pet pet) throws DAOException {

        Connection connection = null;
        PreparedStatement statement = null;
        String sql = CREATE_NEW_PET;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, pet.getOwner().getId());
            statement.setString(2, pet.getName());
            statement.setInt(3, pet.getAge());
            statement.setString(4, pet.getBreed().toString());
            statement.setDouble(5, pet.getWeight());
            statement.executeUpdate();
        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connectionPool.closeConnection(connection, statement);
            } catch (ConnectionPoolException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public Pet findById(int petId) throws DAOException {
        Pet pet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = FIND_PET_BY_ID;

        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, petId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                pet = BuilderFactory.getPetBuilder().buildPet(resultSet);
            } else {
                pet = new Pet();
            }

        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connectionPool.closeConnection(connection, statement, resultSet);
            } catch (ConnectionPoolException e) {
                e.printStackTrace();
            }
        }
        return pet;
    }

    @Override
    public List<Pet> userPets(User user) throws DAOException {
        List<Pet> pets = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = FIND_ALL_PETS_BY_WALKER_ID;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,user.getId());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                pets.add(BuilderFactory.getPetBuilder().buildPet(resultSet));
            }
        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connectionPool.closeConnection(connection, statement, resultSet);
            } catch (ConnectionPoolException e) {
                e.printStackTrace();
            }
        }
        return pets;
    }
}
