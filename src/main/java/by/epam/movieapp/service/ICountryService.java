package by.epam.movieapp.service;

import by.epam.movieapp.model.Country;
import by.epam.movieapp.service.exception.ServiceException;

import java.util.List;

/**
 * @author Olga Shahray
 */
public interface ICountryService {

    void save(Country country) throws ServiceException;

    void update(Country country) throws ServiceException;

    boolean delete(int id) throws ServiceException;

    List<Country> getAll() throws ServiceException;

    Country get(int countryId) throws ServiceException;
}
