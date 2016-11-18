package by.epam.movieapp.service;

import by.epam.movieapp.model.Film;
import by.epam.movieapp.service.exception.ServiceException;

import java.util.List;

/**
 * @author Olga Shahray
 */
public interface IFilmService {

    void save(String[] genres, String[] filmMakers, Object... params) throws ServiceException;

    void update(int id, String[] genres, String[] filmMakers, Object... params) throws ServiceException;

    Film get(int id) throws ServiceException;

    boolean delete(int id) throws ServiceException;

    List<Film> getByYear(int year, int offset, int count) throws ServiceException;

    //PagingListDTO<Film> getFilteredFilms(Map<String, List<String>> filterParams, String order, int offset, int count)  throws ServiceException;

    //PagingListDTO<Film> getAll(String order, int offset, int count) throws ServiceException;

    //PagingListDTO<Film> getFavoriteFilms(int userId, int offset, int count) throws ServiceException;

    void saveFavoriteFilm(int id, int filmId) throws ServiceException;

    boolean deleteFavoriteFilm(int id, int filmId) throws ServiceException;

    List<Film> search(String searchLine)throws ServiceException;

    boolean isFavoriteFilm(int id, int filmId) throws ServiceException;
}
