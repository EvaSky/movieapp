package by.epam.movieapp.repository.mock;

import by.epam.movieapp.model.FilmMaker;
import by.epam.movieapp.repository.IFilmMakerRepository;
import by.epam.movieapp.repository.exception.RepositoryException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Olga Shahray
 */
@Repository
public class MockFilmMakerRepository implements IFilmMakerRepository{
    @Override
    public void save(FilmMaker filmMaker) throws RepositoryException {

    }

    @Override
    public boolean delete(int id) throws RepositoryException {
        return false;
    }

    @Override
    public FilmMaker get(int id) throws RepositoryException {
        return null;
    }

    @Override
    public List<FilmMaker> getAll(int offset, int count) throws RepositoryException {
        return null;
    }

    @Override
    public List<FilmMaker> getAll() throws RepositoryException {
        return null;
    }

    @Override
    public int getCountFilmMakers() throws RepositoryException {
        return 0;
    }
}
