package by.epam.movieapp.repository.impl.jdbc;

import by.epam.movieapp.model.Comment;
import by.epam.movieapp.model.CommentStatus;
import by.epam.movieapp.repository.ICommentRepository;
import by.epam.movieapp.repository.exception.RepositoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Olga Shahray
 */
@Repository
public class JdbcCommentRepositoryImpl implements ICommentRepository {
    private static final RowMapper<Comment> ROW_MAPPER =
            (rs, rowNum) ->
                    new Comment(rs.getInt("id"), rs.getInt("mark"), rs.getString("comment"),
                            rs.getTimestamp("date_com").toLocalDateTime(), CommentStatus.valueOf(rs.getString("status").toUpperCase()));
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertComment;

    @Autowired
    public JdbcCommentRepositoryImpl(DataSource dataSource) {
        this.insertComment = new SimpleJdbcInsert(dataSource)
                .withTableName("COMMENTS")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Comment save(Comment comment, int filmId, int userId) throws RepositoryException {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", comment.getId())
                .addValue("film_id", filmId)
                .addValue("user_id", userId)
                .addValue("mark", comment.getMark())
                .addValue("comment", comment.getComment())
                .addValue("date_com", Timestamp.valueOf(comment.getDateComment()))
                .addValue("status", comment.getStatus().name().toLowerCase());

        if (comment.isNew()) {
            Number newKey = insertComment.executeAndReturnKey(map);
            comment.setId(newKey.intValue());
        } else {
            namedParameterJdbcTemplate.update(
                    "UPDATE comments SET mark=:mark, comment=:comment, date_com=:dateComment, " +
                            "status=:status WHERE id=:id AND user_id=:user_id AND film_id=:film_id", map);
        }
        return comment;
    }

    @Override
    public boolean delete(int id, int filmId, int userId) throws RepositoryException {
        return jdbcTemplate.update("DELETE FROM comments WHERE id=? AND film_id=? AND user_id=?", id, filmId, userId) != 0;
    }

    @Override
    public Comment get(int id, int filmId, int userId) {
        List<Comment> comments = jdbcTemplate.query(
                "SELECT * FROM comments WHERE id = ? AND film_id = ? AND user_id = ?", ROW_MAPPER, id, filmId, userId);
        return DataAccessUtils.singleResult(comments);
    }

    @Override
    public List<Comment> getAllOfUser(int userId) throws RepositoryException {
        return jdbcTemplate.query(
                "SELECT * FROM comments WHERE user_id=? ORDER BY date_com DESC", ROW_MAPPER, userId);
    }

    @Override
    public List<Comment> getAllOfFilm(int filmId) throws RepositoryException {
        return jdbcTemplate.query(
                "SELECT * FROM comments WHERE film_id=? ORDER BY date_com DESC", ROW_MAPPER, filmId);
    }

    @Override
    public List<Comment> getAll() throws RepositoryException {
        return jdbcTemplate.query(
                "SELECT * FROM comments ORDER BY date_com DESC", ROW_MAPPER);
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
