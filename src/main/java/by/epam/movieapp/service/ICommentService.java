package by.epam.movieapp.service;

import by.epam.movieapp.model.Comment;
import by.epam.movieapp.model.CommentStatus;
import by.epam.movieapp.service.exception.ServiceException;

import java.util.List;

/**
 * @author Olga Shahray
 */
public interface ICommentService {

    Comment save(Comment comment, int filmId, int userId) throws ServiceException;

    void update(int id, CommentStatus status)  throws ServiceException;

    boolean delete(int id, int filmId, int userId) throws ServiceException;

    List<Comment> getAllOfUser(int userId) throws ServiceException;

    Comment get(int id, int filmId, int userId) throws ServiceException;

    //PagingListDTO<Comment> getByStatus(CommentStatus status, int offset, int count) throws ServiceException;

    int getCount(CommentStatus status) throws ServiceException;
}
