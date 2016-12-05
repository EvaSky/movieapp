package by.epam.movieapp.service.impl;

import by.epam.movieapp.model.Country;
import by.epam.movieapp.repository.ICountryRepository;
import by.epam.movieapp.repository.exception.RepositoryException;
import by.epam.movieapp.service.ICountryService;
import by.epam.movieapp.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Olga Shahray
 */
@Service
public class CountryServiceImpl implements ICountryService {

    @Autowired
    private ICountryRepository countryRepository;

    @Override
    public void save(Country country) throws ServiceException {
        try {
            countryRepository.save(country);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(Country country) throws ServiceException {
        try {
            countryRepository.save(country);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean delete(int id) throws ServiceException {
        try {
            return countryRepository.delete(id);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Country> getAll() throws ServiceException {
        try {
            return countryRepository.getAll();
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Country get(int id) throws ServiceException {
        try {
            return countryRepository.get(id);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }
}
