package by.epam.movieapp.service;

import by.epam.movieapp.model.Genre;
import by.epam.movieapp.service.exception.ServiceException;

import java.util.List;

/**
 * @author Olga Shahray
 */
public interface IGenreService {

    Genre save(Genre genre) throws ServiceException;

    void update(Genre genre) throws ServiceException;

    Genre get(int id) throws ServiceException;

    boolean delete(int id) throws ServiceException;

    List<Genre> getAll() throws ServiceException;
}
