package by.epam.movieapp.repository.impl.jdbc;

import by.epam.movieapp.model.Discount;
import by.epam.movieapp.repository.IDiscountRepository;
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
public class JdbcDiscountRepositoryImpl implements IDiscountRepository {
    private static final BeanPropertyRowMapper<Discount> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Discount.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertDiscount;

    @Autowired
    public JdbcDiscountRepositoryImpl(DataSource dataSource) {
        this.insertDiscount = new SimpleJdbcInsert(dataSource)
                .withTableName("DISCOUNT")
                .usingGeneratedKeyColumns("id");
    }
    @Override
    public void save(Discount discount) throws RepositoryException {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", discount.getId())
                .addValue("sum_from", discount.getSumFrom())
                .addValue("value", discount.getValue());

        if (discount.isNew()) {
            Number newKey = insertDiscount.executeAndReturnKey(map);
            discount.setId(newKey.intValue());
        } else {
            namedParameterJdbcTemplate.update(
                    "UPDATE discount SET sum_from=:sum_from, value=:value WHERE id=:id", map);
        }
    }

    @Override
    public Discount getUserDiscount(int userId) throws RepositoryException {
        return null;
    }

    @Override
    public boolean delete(int discountId) throws RepositoryException {
        return jdbcTemplate.update("DELETE FROM discount WHERE id=?", discountId) != 0;
    }

    @Override
    public List<Discount> getAll() throws RepositoryException {
        return jdbcTemplate.query("SELECT * FROM discount ORDER BY sum_from", ROW_MAPPER);
    }

    @Override
    public Discount get(int id) throws RepositoryException {
        return jdbcTemplate.queryForObject("SELECT * FROM discount WHERE id=?", ROW_MAPPER, id);
    }
}
