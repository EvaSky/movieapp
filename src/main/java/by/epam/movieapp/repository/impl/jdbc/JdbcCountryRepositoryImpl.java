package by.epam.movieapp.repository.impl.jdbc;

import by.epam.movieapp.model.Country;
import by.epam.movieapp.repository.ICountryRepository;
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
public class JdbcCountryRepositoryImpl implements ICountryRepository {

    private static final BeanPropertyRowMapper<Country> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Country.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertCountry;

    @Autowired
    public JdbcCountryRepositoryImpl(DataSource dataSource) {
        this.insertCountry = new SimpleJdbcInsert(dataSource)
                .withTableName("COUNTRY")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public void save(Country country) throws RepositoryException {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", country.getId())
                .addValue("country", country.getCountry());

        if (country.isNew()) {
            Number newKey = insertCountry.executeAndReturnKey(map);
            country.setId(newKey.intValue());
        } else {
            namedParameterJdbcTemplate.update(
                    "UPDATE country SET country=:country WHERE id=:id", map);
        }
    }

    @Override
    public Country get(int id) throws RepositoryException {
        return jdbcTemplate.queryForObject("SELECT * FROM country WHERE id=?", ROW_MAPPER, id);
    }

    @Override
    public boolean delete(int countryId) throws RepositoryException {
        return jdbcTemplate.update("DELETE FROM country WHERE id=?", countryId) != 0;
    }

    @Override
    public List<Country> getAll() throws RepositoryException {
        return jdbcTemplate.query("SELECT * FROM country ORDER BY country", ROW_MAPPER);
    }
}
