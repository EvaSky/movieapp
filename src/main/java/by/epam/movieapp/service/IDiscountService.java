package by.epam.movieapp.service;


import by.epam.movieapp.model.Discount;
import by.epam.movieapp.service.exception.ServiceException;

import java.util.List;

/**
 * @author Olga Shahray
 */
public interface IDiscountService {

    void save(Discount discount) throws ServiceException;

    void update(Discount discount) throws ServiceException;

    Discount get(int id)  throws ServiceException;

    boolean delete(int id) throws ServiceException;

    List<Discount> getAll() throws ServiceException;

    double getUserDiscount(int userId) throws ServiceException;


}
