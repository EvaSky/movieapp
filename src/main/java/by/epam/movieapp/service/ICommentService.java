package by.epam.movieapp.service;

import by.epam.movieapp.model.Comment;
import by.epam.movieapp.model.CommentStatus;
import by.epam.movieapp.model.User;
import by.epam.movieapp.service.exception.ServiceException;

import java.util.List;

/**
 * @author Olga Shahray
 */
public interface ICommentService {

    void save(User user, int filmId, int mark, String commentText) throws ServiceException;

    void update(int id, CommentStatus status)  throws ServiceException;

    boolean delete(int id) throws ServiceException;

    List<Comment> getAllOfUser(int userId) throws ServiceException;

    //PagingListDTO<Comment> getByStatus(CommentStatus status, int offset, int count) throws ServiceException;

    int getCount(CommentStatus status) throws ServiceException;
}
