package by.fpmibsu.doggo.service;
import by.fpmibsu.doggo.entity.Order;
import by.fpmibsu.doggo.entity.User;
import by.fpmibsu.doggo.service.exception.ServiceException;

import java.util.List;

public interface OrderService {
    Order findByCardNumberGetter(Long cardNumber)throws ServiceException;
    List<Order> findAllFromUser(User user) throws ServiceException;
    void createOrder(Order order) throws ServiceException;
    void updateOrder(Order order) throws ServiceException;
}
