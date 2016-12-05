package by.epam.movieapp.service.impl;

import by.epam.movieapp.model.Discount;
import by.epam.movieapp.repository.IDiscountRepository;
import by.epam.movieapp.repository.exception.RepositoryException;
import by.epam.movieapp.service.IDiscountService;
import by.epam.movieapp.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Olga Shahray
 */
@Service
public class DiscountServiceImpl implements IDiscountService{

    @Autowired
    private IDiscountRepository discountRepository;

    @Override
    public void save(Discount discount) throws ServiceException {
        try {
            discountRepository.save(discount);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(Discount discount) throws ServiceException {
        try {
            discountRepository.save(discount);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Discount get(int id) throws ServiceException {
        try {
            return discountRepository.get(id);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean delete(int id) throws ServiceException {
        try {
            return discountRepository.delete(id);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Discount> getAll() throws ServiceException {
        try {
            return discountRepository.getAll();
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public double getUserDiscount(int userId) throws ServiceException {
        try {
            return discountRepository.getUserDiscount(userId).getValue();
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }
}
