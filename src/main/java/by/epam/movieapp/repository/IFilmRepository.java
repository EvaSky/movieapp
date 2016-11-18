package by.epam.movieapp.repository;

import by.epam.movieapp.model.Film;
import by.epam.movieapp.model.FilmMaker;
import by.epam.movieapp.model.Genre;
import by.epam.movieapp.repository.exception.RepositoryException;

import java.util.List;
import java.util.Map;

/**
 * @author Olga Shahray
 */
public interface IFilmRepository {

    void save(Film film) throws RepositoryException;

    void saveFilmGenres(int filmId, List<Genre> genres) throws RepositoryException;

    void saveFilmMakers(int filmId, List<FilmMaker> filmMakers) throws RepositoryException;

    void update(Film film) throws RepositoryException;

    // false if not found
    boolean delete(int id) throws RepositoryException;

    //only for testing
    boolean deleteByTitle(String title) throws RepositoryException;

    // null if not found
    Film get(int id) throws RepositoryException;

    List<Film> getFilteredFilms(Map<String, List<String>> filterParams, String orderBy, int offset, int count)  throws RepositoryException;

    List<Film> getByYear(int year, int offset, int count) throws RepositoryException;

    List<Genre> getAllGenresOfFilm(int filmId) throws RepositoryException;

    List<FilmMaker> getMakersOfFilm(int filmId) throws RepositoryException;

    int getCountFilm(Map<String, List<String>> filterParams) throws RepositoryException;

    List<Film> getFavoriteFilms(int id, int offset, int count) throws RepositoryException;

    int getCountFavoriteFilm(int id) throws RepositoryException;

    void saveFavoriteFilm(int userId, int filmId) throws RepositoryException;

    boolean deleteFavoriteFilm(int userId, int filmId) throws RepositoryException;

    List<Film> search(String[] keywords) throws RepositoryException;

    boolean isFavoriteFilm(int userId, int filmId)throws RepositoryException;
}
