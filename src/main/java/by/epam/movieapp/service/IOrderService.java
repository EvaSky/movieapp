package by.epam.movieapp.service;

import by.epam.movieapp.model.Order;
import by.epam.movieapp.model.OrderStatus;
import by.epam.movieapp.service.exception.ServiceException;

import java.util.List;

/**
 * @author Olga Shahray
 */
public interface IOrderService {

    void save(Order order, int filmId, int userId) throws ServiceException;

    void update(Order order, int filmId, int userId) throws ServiceException;

    boolean delete(int id, int filmId, int userId) throws ServiceException;

    Order get(int id, int filmId, int userId) throws ServiceException;

    List<Order> getAll() throws ServiceException;

    List<Order> getUserOrdersByStatus(int userId, OrderStatus status) throws ServiceException;

    void updateStatus(int[] orderIdArr, OrderStatus status) throws ServiceException;

    double getTotalAmount(int userId) throws ServiceException;


}
