package by.epam.movieapp.service;

import by.epam.movieapp.model.Order;
import by.epam.movieapp.model.OrderStatus;
import by.epam.movieapp.model.User;
import by.epam.movieapp.service.exception.ServiceException;

import java.util.List;

/**
 * @author Olga Shahray
 */
public interface IOrderService {

    void save(int filmId, double price, User user) throws ServiceException;

    boolean delete(int orderId) throws ServiceException;

    void updateStatus(int orderId, OrderStatus status) throws ServiceException;

    void updateStatus(int[] orderIdArr, OrderStatus status) throws ServiceException;

    List<Order> getUserOrdersByStatus(int userId, OrderStatus status) throws ServiceException;

    double getTotalAmount(int userId) throws ServiceException;

    Order get(int orderId) throws ServiceException;
}
