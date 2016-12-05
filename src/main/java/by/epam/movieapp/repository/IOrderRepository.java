package by.epam.movieapp.repository;

import by.epam.movieapp.model.Order;
import by.epam.movieapp.model.OrderStatus;
import by.epam.movieapp.repository.exception.RepositoryException;

import java.util.List;

/**
 * @author Olga Shahray
 */
public interface IOrderRepository {

    void save(Order order, int filmId, int userId) throws RepositoryException;

    // false if not found
    boolean delete(int id, int filmId, int userId) throws RepositoryException;

    // null if not found
    Order get(int id, int filmId, int userId) throws RepositoryException;

    List<Order> getOrdersOfUser(int userId, OrderStatus status) throws RepositoryException;

    List<Order> getAllOfFilm(int filmId) throws RepositoryException;

    List<Order> getAll() throws RepositoryException;

    double getTotalAmount(int userId) throws RepositoryException;

}
