package by.epam.movieapp.repository.impl.jdbc;

import by.epam.movieapp.model.Genre;
import by.epam.movieapp.repository.IGenreRepository;
import by.epam.movieapp.repository.exception.RepositoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author Olga Shahray
 */
@Repository
public class JdbcGenreRepositoryImpl implements IGenreRepository {
    private static final BeanPropertyRowMapper<Genre> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Genre.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertGenre;

    @Autowired
    public JdbcGenreRepositoryImpl(DataSource dataSource) {
        this.insertGenre = new SimpleJdbcInsert(dataSource)
                .withTableName("ALLGENRES")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Genre save(Genre genre) throws RepositoryException {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", genre.getId())
                .addValue("genre_name", genre.getGenreName());

        if (genre.isNew()) {
            Number newKey = insertGenre.executeAndReturnKey(map);
            genre.setId(newKey.intValue());
        } else {
            namedParameterJdbcTemplate.update(
                    "UPDATE allgenres SET genre_name=:genre_name WHERE id=:id", map);
        }
        return genre;
    }

    @Override
    public Genre get(int id) throws RepositoryException {
        return jdbcTemplate.queryForObject("SELECT * FROM allgenres WHERE id=?", ROW_MAPPER, id);
    }

    @Override
    public boolean delete(int id) throws RepositoryException {
        return jdbcTemplate.update("DELETE FROM allgenres WHERE id=?", id) != 0;
    }

    @Override
    public List<Genre> getAll() throws RepositoryException {
        return jdbcTemplate.query("SELECT * FROM allgenres ORDER BY genre_name", ROW_MAPPER);
    }
}
