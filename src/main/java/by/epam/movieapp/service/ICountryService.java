package by.epam.movieapp.service;

import by.epam.movieapp.model.Country;
import by.epam.movieapp.service.exception.ServiceException;

import java.util.List;

/**
 * @author Olga Shahray
 */
public interface ICountryService {

    void save(String countryName) throws ServiceException;

    void update(int id, String countryName) throws ServiceException;

    boolean delete(int id) throws ServiceException;

    List<Country> getAll() throws ServiceException;
}
