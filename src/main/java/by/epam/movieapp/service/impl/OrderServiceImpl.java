package by.epam.movieapp.service.impl;

import by.epam.movieapp.model.Order;
import by.epam.movieapp.model.OrderStatus;
import by.epam.movieapp.repository.IOrderRepository;
import by.epam.movieapp.repository.exception.RepositoryException;
import by.epam.movieapp.service.IOrderService;
import by.epam.movieapp.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Olga Shahray
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public void save(Order order, int filmId, int userId) throws ServiceException {
        try {
            orderRepository.save(order, filmId, userId);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(Order order, int filmId, int userId) throws ServiceException {
        try {
            orderRepository.save(order, filmId, userId);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean delete(int id, int filmId, int userId) throws ServiceException {
        try {
            return orderRepository.delete(id, filmId, userId);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Order get(int id, int filmId, int userId) throws ServiceException {
        try {
            return orderRepository.get(id, filmId, userId);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Order> getAll() throws ServiceException {
        try {
            return orderRepository.getAll();
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Order> getUserOrdersByStatus(int userId, OrderStatus status) throws ServiceException {
        try {
            return orderRepository.getOrdersOfUser(userId, status);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateStatus(int[] orderIdArr, OrderStatus status) throws ServiceException {

    }

    @Override
    public double getTotalAmount(int userId) throws ServiceException {
        return 0;
    }
}
