package by.epam.movieapp.service;

import by.epam.movieapp.model.Genre;
import by.epam.movieapp.service.exception.ServiceException;

import java.util.List;

/**
 * @author Olga Shahray
 */
public interface IGenreService {

    void save(Genre genre) throws ServiceException;

    void update(int id, String genre) throws ServiceException;

    boolean delete(int id) throws ServiceException;

    List<Genre> getAll() throws ServiceException;
}
