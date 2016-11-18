package by.epam.movieapp.repository;

import by.epam.movieapp.model.FilmMaker;
import by.epam.movieapp.repository.exception.RepositoryException;

import java.util.List;

/**
 * @author Olga Shahray
 */
public interface IFilmMakerRepository {

    void save(FilmMaker filmMaker) throws RepositoryException;

    void update(FilmMaker filmMaker) throws RepositoryException;

    // false if not found
    boolean delete(int id) throws RepositoryException;

    // null if not found
    FilmMaker get(int id) throws RepositoryException;

    List<FilmMaker> getAll(int offset, int count) throws RepositoryException;

    List<FilmMaker> getAll() throws RepositoryException;

    int getCountFilmMakers() throws RepositoryException;
}
