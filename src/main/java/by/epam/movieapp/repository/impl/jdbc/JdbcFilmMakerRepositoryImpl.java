package by.epam.movieapp.repository.impl.jdbc;

import by.epam.movieapp.model.FilmMaker;
import by.epam.movieapp.model.Profession;
import by.epam.movieapp.repository.IFilmMakerRepository;
import by.epam.movieapp.repository.exception.RepositoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
public class JdbcFilmMakerRepositoryImpl implements IFilmMakerRepository {
    private static final RowMapper<FilmMaker> ROW_MAPPER =
            (rs, rowNum) ->
                    new FilmMaker(rs.getInt("id"), rs.getString("name"), Profession.valueOf(rs.getString("profession").toUpperCase()));
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertFilmMaker;

    @Autowired
    public JdbcFilmMakerRepositoryImpl(DataSource dataSource) {
        this.insertFilmMaker = new SimpleJdbcInsert(dataSource)
                .withTableName("ALLFILMMAKERS")
                .usingGeneratedKeyColumns("id");
    }
    @Override
    public void save(FilmMaker filmMaker) throws RepositoryException {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", filmMaker.getId())
                .addValue("name", filmMaker.getName())
                .addValue("profession", filmMaker.getProfession().name().toLowerCase());

        if (filmMaker.isNew()) {
            Number newKey = insertFilmMaker.executeAndReturnKey(map);
            filmMaker.setId(newKey.intValue());
        } else {
            namedParameterJdbcTemplate.update(
                    "UPDATE allfilmmakers SET name=:name, profession=:profession WHERE id=:id", map);
        }
    }

    @Override
    public boolean delete(int id) throws RepositoryException {
        return jdbcTemplate.update("DELETE FROM allfilmmakers WHERE id=?", id) != 0;
    }

    @Override
    public FilmMaker get(int id) throws RepositoryException {
        return jdbcTemplate.queryForObject("SELECT * FROM allfilmmakers WHERE id=?", ROW_MAPPER, id);
    }

    @Override
    public List<FilmMaker> getAll(int offset, int count) throws RepositoryException {
        return null;
    }

    @Override
    public List<FilmMaker> getAll() throws RepositoryException {
        return jdbcTemplate.query("SELECT * FROM allfilmmakers ORDER BY name", ROW_MAPPER);
    }

    @Override
    public int getCountFilmMakers() throws RepositoryException {
        return 0;
    }
}
