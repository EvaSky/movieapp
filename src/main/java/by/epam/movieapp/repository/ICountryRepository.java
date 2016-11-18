package by.epam.movieapp.repository;

import by.epam.movieapp.model.Country;
import by.epam.movieapp.repository.exception.RepositoryException;

import java.util.List;

/**
 * @author Olga Shahray
 */
public interface ICountryRepository {

    void save(Country country) throws RepositoryException;

    void update(Country country) throws RepositoryException;

    // false if not found
    boolean delete(int countryId) throws RepositoryException;

    List<Country> getAll() throws RepositoryException;


}
