package by.fpmibsu.doggo.dao;

import by.fpmibsu.doggo.dao.exception.DAOException;
import by.fpmibsu.doggo.entity.Order;
import by.fpmibsu.doggo.entity.User;

import java.util.List;

public interface OrderDAO {


    Order findByCardNumberGetter(Long cardNumber) throws DAOException;
    List<Order> findAllFromUser(User user) throws DAOException;
    List<Order> findAll() throws DAOException;
    void createOrder(Order order) throws DAOException;
    void updateOrder(Order order) throws DAOException;

}
