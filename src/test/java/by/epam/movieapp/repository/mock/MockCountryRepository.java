package by.epam.movieapp.repository.mock;

import by.epam.movieapp.model.Country;
import by.epam.movieapp.repository.ICountryRepository;
import by.epam.movieapp.repository.exception.RepositoryException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Olga Shahray
 */
@Repository
public class MockCountryRepository implements ICountryRepository{

    @Override
    public void save(Country country) throws RepositoryException {

    }

    @Override
    public Country get(int id) throws RepositoryException {
        return null;
    }

    @Override
    public boolean delete(int countryId) throws RepositoryException {
        return false;
    }

    @Override
    public List<Country> getAll() throws RepositoryException {
        return null;
    }
}
