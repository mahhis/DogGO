package by.fpmibsu.doggo.service.impl;


import by.fpmibsu.doggo.dao.FactoryDAO;
import by.fpmibsu.doggo.dao.UserDAO;
import by.fpmibsu.doggo.dao.exception.DAOException;
import by.fpmibsu.doggo.entity.User;
import by.fpmibsu.doggo.entity.WalkerInfo;
import by.fpmibsu.doggo.service.UserService;
import by.fpmibsu.doggo.service.exception.ServiceException;

import java.util.List;

    public class UserServiceImpl implements UserService {
    private static final UserDAO userDAO = FactoryDAO.getInstance().getUserDAO();

    @Override
    public boolean authorisation(String username, String password)throws ServiceException {
        FactoryDAO factory = FactoryDAO.getInstance();
        UserDAO userDAO = factory.getUserDAO();
        boolean result;
        result = userDAO.authorization(username, password);

        return result;
    }



    @Override
    public void registration(User newUser) throws ServiceException {

            try {
                userDAO.registration(newUser);
            } catch (DAOException e) {
                e.printStackTrace();
            }

    }



    @Override
    public WalkerInfo findByWalkerId(int walkerId) throws ServiceException {

        WalkerInfo walkerInfo = null;
        try {
            walkerInfo = userDAO.findByWalkerId(walkerId);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }

        return walkerInfo;
    }


    @Override
    public User findByUsername(String username) throws ServiceException {
        FactoryDAO factoryDAO = FactoryDAO.getInstance();
        UserDAO userDAO = factoryDAO.getUserDAO();
        User user;

        try {
            user = userDAO.findByUsername(username);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return user;
    }

    @Override
    public List<WalkerInfo> walkerList() throws ServiceException {
        FactoryDAO factoryDAO = FactoryDAO.getInstance();
        UserDAO userDAO = factoryDAO.getUserDAO();
        List<WalkerInfo> walkers;
        try {
            walkers = userDAO.findAllWalkers();
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }

        return walkers;
    }
}

