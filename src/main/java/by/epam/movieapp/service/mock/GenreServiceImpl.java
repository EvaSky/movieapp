package by.epam.movieapp.service.mock;

import by.epam.movieapp.model.Genre;
import by.epam.movieapp.repository.IGenreRepository;
import by.epam.movieapp.repository.exception.RepositoryException;
import by.epam.movieapp.service.IGenreService;
import by.epam.movieapp.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Olga Shahray
 */
@Service
public class GenreServiceImpl implements IGenreService {
    @Autowired
    private IGenreRepository genreRepository;

    @Override
    public void save(Genre genre) throws ServiceException {
        try {
            genreRepository.save(genre);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(int id, String genre) throws ServiceException {
        try {
            genreRepository.save(new Genre(id, genre));
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean delete(int id) throws ServiceException {
        try {
            return genreRepository.delete(id);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Genre> getAll() throws ServiceException {
        try {
            return genreRepository.getAll();
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }
}
