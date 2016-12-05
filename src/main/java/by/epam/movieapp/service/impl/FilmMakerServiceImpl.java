package by.epam.movieapp.service.impl;

import by.epam.movieapp.model.FilmMaker;
import by.epam.movieapp.repository.IFilmMakerRepository;
import by.epam.movieapp.repository.exception.RepositoryException;
import by.epam.movieapp.service.IFilmMakerService;
import by.epam.movieapp.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Olga Shahray
 */
@Service
public class FilmMakerServiceImpl implements IFilmMakerService {

    @Autowired
    private IFilmMakerRepository filmMakerRepository;

    @Override
    public void save(FilmMaker filmMaker) throws ServiceException {
        try {
            filmMakerRepository.save(filmMaker);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(FilmMaker filmMaker) throws ServiceException {
        try {
            filmMakerRepository.save(filmMaker);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean delete(int id) throws ServiceException {
        try {
            return filmMakerRepository.delete(id);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public FilmMaker get(int id) throws ServiceException {
        try {
            return filmMakerRepository.get(id);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<FilmMaker> getAll() throws ServiceException {
        try {
            return filmMakerRepository.getAll();
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }
}
