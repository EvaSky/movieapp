package by.epam.movieapp.service.impl;

import by.epam.movieapp.model.Comment;
import by.epam.movieapp.model.CommentStatus;
import by.epam.movieapp.repository.ICommentRepository;
import by.epam.movieapp.repository.exception.RepositoryException;
import by.epam.movieapp.service.ICommentService;
import by.epam.movieapp.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Olga Shahray
 */
@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private ICommentRepository commentRepository;

    @Override
    public Comment save(Comment comment, int filmId, int userId) throws ServiceException {
        try {
            return commentRepository.save(comment, filmId, userId);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(int id, CommentStatus status) throws ServiceException {

    }

    @Override
    public boolean delete(int id, int filmId, int userId) throws ServiceException {
        try {
            return commentRepository.delete(id, filmId, userId);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Comment> getAllOfUser(int userId) throws ServiceException {
        try {
            return commentRepository.getAllOfUser(userId);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Comment get(int id, int filmId, int userId) throws ServiceException {
        try {
            return commentRepository.get(id, filmId, userId);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int getCount(CommentStatus status) throws ServiceException {
        return 0;
    }
}
