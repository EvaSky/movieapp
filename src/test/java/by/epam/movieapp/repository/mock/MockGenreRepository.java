package by.epam.movieapp.repository.mock;

import by.epam.movieapp.LoggerWrapper;
import by.epam.movieapp.model.Genre;
import by.epam.movieapp.repository.IGenreRepository;
import by.epam.movieapp.repository.exception.RepositoryException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Olga Shahray
 */
@Repository
public class MockGenreRepository implements IGenreRepository {
    private static final LoggerWrapper LOG = LoggerWrapper.get(MockGenreRepository.class);

    @Override
    public Genre save(Genre genre) throws RepositoryException {
        LOG.info("save genre in MockGenreRepository");
        return genre;
    }

    @Override
    public Genre get(int id) throws RepositoryException {
        LOG.info("get genre in MockGenreRepository");
        return null;
    }

    @Override
    public boolean delete(int id) throws RepositoryException {
        LOG.info("delete genre" + id + " in MockGenreRepository");
        return true;
    }

    @Override
    public List<Genre> getAll() throws RepositoryException {
        LOG.info("get all genres in MockGenreRepository");
        return null;
    }
}
