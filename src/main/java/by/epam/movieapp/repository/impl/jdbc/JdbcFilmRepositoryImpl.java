package by.epam.movieapp.repository.impl.jdbc;

import by.epam.movieapp.model.Country;
import by.epam.movieapp.model.Film;
import by.epam.movieapp.model.FilmMaker;
import by.epam.movieapp.model.Genre;
import by.epam.movieapp.repository.IFilmRepository;
import by.epam.movieapp.repository.exception.RepositoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Olga Shahray
 */
@Repository
public class JdbcFilmRepositoryImpl implements IFilmRepository {

    private static final RowMapper<Film> ROW_MAPPER =
            (rs, rowNum) -> {
                Film f = new Film(rs.getInt("id"), rs.getString("title"), rs.getInt("year"),
                        rs.getString("description"), rs.getInt("duration"), rs.getInt("age_restriction"),
                        rs.getDouble("price"), rs.getString("poster"), rs.getDouble("rating"),
                        rs.getDate("date_add").toLocalDate(), rs.getString("video"));
                f.setCountry(new Country(rs.getInt("country_id"), rs.getString("country")));
                return f;
            };


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertFilm;

    @Autowired
    public JdbcFilmRepositoryImpl(DataSource dataSource) {
        this.insertFilm = new SimpleJdbcInsert(dataSource)
                .withTableName("FILMS")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public void save(Film film) throws RepositoryException {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", film.getId())
                .addValue("title", film.getTitle())
                .addValue("year", film.getYear())
                .addValue("country_id", film.getCountry().getId())
                .addValue("description", film.getDescription())
                .addValue("duration", film.getDuration())
                .addValue("age_restriction", film.getAgeRestriction())
                .addValue("price", film.getPrice())
                .addValue("poster", film.getPoster())
                .addValue("video", film.getVideo())
                .addValue("date_add", Date.valueOf(film.getDateAdd()));

        if (film.isNew()) {
            Number newKey = insertFilm.executeAndReturnKey(map);
            film.setId(newKey.intValue());
        } else {
            namedParameterJdbcTemplate.update(
                    "UPDATE films SET title=:title, year=:year, country_id=:country_id, " +
                            "description=:description, duration=:duration, age_restriction=:age_restriction, " +
                            "price=:price, poster=:poster, video=:video, date_add=:date_add WHERE id=:id", map);
        }
    }

    @Override
    public void saveFilmGenres(int filmId, List<Genre> genres) throws RepositoryException {

    }

    @Override
    public void saveFilmMakers(int filmId, List<FilmMaker> filmMakers) throws RepositoryException {

    }

    @Override
    public boolean delete(int id) throws RepositoryException {
        return jdbcTemplate.update("DELETE FROM films WHERE id=?", id) != 0;
    }

    @Override
    public boolean deleteByTitle(String title) throws RepositoryException {
        return false;
    }

    @Override
    public Film get(int id) throws RepositoryException {
        return jdbcTemplate.queryForObject("SELECT films.id, title, year, description, duration, " +
                "age_restriction, price, poster, video, date_add, rating, films.country_id, country.country FROM films " +
                "INNER JOIN country ON films.country_id = country.id WHERE films.id=?", ROW_MAPPER, id);
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
        return jdbcTemplate.query("SELECT films.id, title, year, description, duration, " +
                "age_restriction, price, poster, video, date_add, rating, films.country_id, country.country FROM films " +
                "INNER JOIN country ON films.country_id = country.id ORDER BY date_add DESC, title", ROW_MAPPER);
    }
}
