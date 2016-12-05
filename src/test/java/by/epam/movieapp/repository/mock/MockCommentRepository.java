package by.epam.movieapp.repository.mock;

import by.epam.movieapp.model.Comment;
import by.epam.movieapp.model.CommentStatus;
import by.epam.movieapp.repository.ICommentRepository;
import by.epam.movieapp.repository.exception.RepositoryException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Olga Shahray
 */
@Repository
public class MockCommentRepository implements ICommentRepository{
    @Override
    public Comment save(Comment comment, int filmId, int userId) throws RepositoryException {
        return null;
    }

    @Override
    public boolean delete(int id, int filmId, int userId) throws RepositoryException {
        return false;
    }

    @Override
    public Comment get(int id, int filmId, int userId) throws RepositoryException {
        return null;
    }

    @Override
    public List<Comment> getAllOfUser(int userId) throws RepositoryException {
        return null;
    }

    @Override
    public List<Comment> getAllOfFilm(int filmId) throws RepositoryException {
        return null;
    }

    @Override
    public List<Comment> getAll() throws RepositoryException {
        return null;
    }

    @Override
    public List<Comment> getByStatus(CommentStatus status, int offset, int count) throws RepositoryException {
        return null;
    }

    @Override
    public int getCount(CommentStatus status) throws RepositoryException {
        return 0;
    }
}
