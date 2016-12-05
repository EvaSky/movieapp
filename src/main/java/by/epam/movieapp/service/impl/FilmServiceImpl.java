package by.epam.movieapp.service.impl;

import by.epam.movieapp.model.Film;
import by.epam.movieapp.repository.IFilmRepository;
import by.epam.movieapp.repository.exception.RepositoryException;
import by.epam.movieapp.service.IFilmService;
import by.epam.movieapp.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Olga Shahray
 */
@Service
public class FilmServiceImpl implements IFilmService {

    @Autowired
    private IFilmRepository filmRepository;

    @Override
    public void save(Film film) throws ServiceException {
        try {
            filmRepository.save(film);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(Film film) throws ServiceException {
        try {
            filmRepository.save(film);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Film get(int id) throws ServiceException {
        try {
            return filmRepository.get(id);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean delete(int id) throws ServiceException {
        try {
            return filmRepository.delete(id);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Film> getAll() throws ServiceException {
        try {
            return filmRepository.getAll();
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Film> getByYear(int year, int offset, int count) throws ServiceException {
        return null;
    }

    @Override
    public void saveFavoriteFilm(int id, int filmId) throws ServiceException {

    }

    @Override
    public boolean deleteFavoriteFilm(int id, int filmId) throws ServiceException {
        return false;
    }

    @Override
    public List<Film> search(String searchLine) throws ServiceException {
        return null;
    }

    @Override
    public boolean isFavoriteFilm(int id, int filmId) throws ServiceException {
        return false;
    }
}
