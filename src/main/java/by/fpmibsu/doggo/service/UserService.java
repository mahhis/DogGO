package by.fpmibsu.doggo.service;

import by.fpmibsu.doggo.entity.User;
import by.fpmibsu.doggo.entity.WalkerInfo;
import by.fpmibsu.doggo.service.exception.ServiceException;

import java.util.List;

public interface UserService {

    public WalkerInfo findByWalkerId(int walkerId) throws ServiceException;

    boolean authorisation(String login, String password)throws ServiceException;
    void registration(User newUser) throws ServiceException;
    User findByUsername(String username) throws ServiceException;

    List<WalkerInfo> walkerList()throws ServiceException;
}
