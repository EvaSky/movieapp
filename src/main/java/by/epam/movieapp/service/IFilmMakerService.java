package by.epam.movieapp.service;

import by.epam.movieapp.model.FilmMaker;
import by.epam.movieapp.service.exception.ServiceException;

import java.util.List;

/**
 * @author Olga Shahray
 */
public interface IFilmMakerService {

    void save(String... params) throws ServiceException;

    void update(int id, String... params) throws ServiceException;

    // false if not found
    boolean delete(int id) throws ServiceException;

    // null if not found
    FilmMaker get(int id) throws ServiceException;

    //PagingListDTO<FilmMaker> getAll(int offset, int count) throws ServiceException;

    List<FilmMaker> getAll() throws ServiceException;
}
