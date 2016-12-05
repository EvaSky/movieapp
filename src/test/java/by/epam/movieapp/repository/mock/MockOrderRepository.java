package by.epam.movieapp.repository.mock;

import by.epam.movieapp.model.Order;
import by.epam.movieapp.model.OrderStatus;
import by.epam.movieapp.repository.IOrderRepository;
import by.epam.movieapp.repository.exception.RepositoryException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Olga Shahray
 */
@Repository
public class MockOrderRepository implements IOrderRepository{
    @Override
    public void save(Order order, int filmId, int userId) throws RepositoryException {

    }

    @Override
    public boolean delete(int id, int filmId, int userId) throws RepositoryException {
        return false;
    }

    @Override
    public Order get(int id, int filmId, int userId) throws RepositoryException {
        return null;
    }

    @Override
    public List<Order> getOrdersOfUser(int userId, OrderStatus status) throws RepositoryException {
        return null;
    }

    @Override
    public List<Order> getAllOfFilm(int filmId) throws RepositoryException {
        return null;
    }

    @Override
    public List<Order> getAll() throws RepositoryException {
        return null;
    }

    @Override
    public double getTotalAmount(int userId) throws RepositoryException {
        return 0;
    }
}
