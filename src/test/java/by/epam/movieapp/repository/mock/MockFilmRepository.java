package by.epam.movieapp.repository.mock;

import by.epam.movieapp.model.Film;
import by.epam.movieapp.model.FilmMaker;
import by.epam.movieapp.model.Genre;
import by.epam.movieapp.repository.IFilmRepository;
import by.epam.movieapp.repository.exception.RepositoryException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Olga Shahray
 */
@Repository
public class MockFilmRepository implements IFilmRepository{
    @Override
    public void save(Film film) throws RepositoryException {

    }

    @Override
    public void saveFilmGenres(int filmId, List<Genre> genres) throws RepositoryException {

    }

    @Override
    public void saveFilmMakers(int filmId, List<FilmMaker> filmMakers) throws RepositoryException {

    }

    @Override
    public boolean delete(int id) throws RepositoryException {
        return false;
    }

    @Override
    public boolean deleteByTitle(String title) throws RepositoryException {
        return false;
    }

    @Override
    public Film get(int id) throws RepositoryException {
        return null;
    }

    @Override
    public List<Film> getFilteredFilms(Map<String, List<String>> filterParams, String orderBy, int offset, int count) throws RepositoryException {
        return null;
    }

    @Override
    public List<Film> getByYear(int year, int offset, int count) throws RepositoryException {
        return null;
    }

    @Override
    public List<Genre> getAllGenresOfFilm(int filmId) throws RepositoryException {
        return null;
    }

    @Override
    public List<FilmMaker> getMakersOfFilm(int filmId) throws RepositoryException {
        return null;
    }

    @Override
    public int getCountFilm(Map<String, List<String>> filterParams) throws RepositoryException {
        return 0;
    }

    @Override
    public List<Film> getFavoriteFilms(int id, int offset, int count) throws RepositoryException {
        return null;
    }

    @Override
    public int getCountFavoriteFilm(int id) throws RepositoryException {
        return 0;
    }

    @Override
    public void saveFavoriteFilm(int userId, int filmId) throws RepositoryException {

    }

    @Override
    public boolean deleteFavoriteFilm(int userId, int filmId) throws RepositoryException {
        return false;
    }

    @Override
    public List<Film> search(String[] keywords) throws RepositoryException {
        return null;
    }

    @Override
    public boolean isFavoriteFilm(int userId, int filmId) throws RepositoryException {
        return false;
    }

    @Override
    public List<Film> getAll() throws RepositoryException {
        return null;
    }
}
