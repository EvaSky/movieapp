package by.epam.movieapp.repository.impl.jdbc;

import by.epam.movieapp.model.Order;
import by.epam.movieapp.model.OrderStatus;
import by.epam.movieapp.repository.IOrderRepository;
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
public class JdbcOrderRepositoryImpl implements IOrderRepository {
    private static final RowMapper<Order> ROW_MAPPER =
            (rs, rowNum) ->
                    new Order(rs.getInt("id"), rs.getTimestamp("date_sale").toLocalDateTime(), rs.getDouble("sum"),
                            OrderStatus.valueOf(rs.getString("status").toUpperCase()));
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertOrder;

    @Autowired
    public JdbcOrderRepositoryImpl(DataSource dataSource) {
        this.insertOrder = new SimpleJdbcInsert(dataSource)
                .withTableName("ORDERS")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public void save(Order order, int filmId, int userId) throws RepositoryException {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", order.getId())
                .addValue("film_id", filmId)
                .addValue("user_id", userId)
                .addValue("date_sale", Timestamp.valueOf(order.getDateSale()))
                .addValue("sum", order.getSum())
                .addValue("status", order.getStatus().name().toLowerCase());

        if (order.isNew()) {
            Number newKey = insertOrder.executeAndReturnKey(map);
            order.setId(newKey.intValue());
        } else {
            namedParameterJdbcTemplate.update(
                    "UPDATE orders SET date_sale=:date_sale, sum=:sum, status=:status " +
                            "WHERE id=:id AND user_id=:user_id AND film_id=:film_id", map);
        }
    }

    @Override
    public boolean delete(int id, int filmId, int userId) throws RepositoryException {
        return jdbcTemplate.update("DELETE FROM orders WHERE id=? AND film_id=? AND user_id=?", id, filmId, userId) != 0;
    }

    @Override
    public Order get(int id, int filmId, int userId) throws RepositoryException {
        List<Order> orders = jdbcTemplate.query(
                "SELECT * FROM orders WHERE id = ? AND film_id = ? AND user_id = ?", ROW_MAPPER, id, filmId, userId);
        return DataAccessUtils.singleResult(orders);
    }

    @Override
    public List<Order> getOrdersOfUser(int userId, OrderStatus status) throws RepositoryException {
        return jdbcTemplate.query(
                "SELECT * FROM orders WHERE user_id=? AND status=? ORDER BY date_sale DESC ", ROW_MAPPER, userId, status.name().toLowerCase());
    }

    @Override
    public List<Order> getAllOfFilm(int filmId) throws RepositoryException {
        return null;
    }

    @Override
    public List<Order> getAll() throws RepositoryException {
        return jdbcTemplate.query(
                "SELECT * FROM orders ORDER BY date_sale DESC", ROW_MAPPER);
    }

    @Override
    public double getTotalAmount(int userId) throws RepositoryException {
        return 0;
    }
}
