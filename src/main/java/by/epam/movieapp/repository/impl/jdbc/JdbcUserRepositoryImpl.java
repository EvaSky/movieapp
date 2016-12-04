package by.epam.movieapp.repository.impl.jdbc;

import by.epam.movieapp.model.Role;
import by.epam.movieapp.model.User;
import by.epam.movieapp.repository.IUserRepository;
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
public class JdbcUserRepositoryImpl implements IUserRepository {
    /*private static final BeanPropertyRowMapper<User> ROW_MAPPER = BeanPropertyRowMapper.newInstance(User.class);*/
    private static final RowMapper<User> ROW_MAPPER =
            (rs, rowNum) ->
                    new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
                            rs.getString("password"), rs.getString("phone"), rs.getString("photo"),
                            rs.getTimestamp("date_reg"),
                            Role.valueOf(rs.getString("role").toUpperCase()));
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertUser;

    @Autowired
    public JdbcUserRepositoryImpl(DataSource dataSource) {
        this.insertUser = new SimpleJdbcInsert(dataSource)
                .withTableName("USERS")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public User save(User user) throws RepositoryException {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", user.getId())
                .addValue("name", user.getName())
                .addValue("email", user.getEmail())
                .addValue("password", user.getPass())
                .addValue("phone", user.getPhone())
                .addValue("photo", user.getPhoto())
                .addValue("dateRegistration", user.getDateRegistration())
                .addValue("role", user.getRole().name().toLowerCase());

        if (user.isNew()) {
            Number newKey = insertUser.executeAndReturnKey(map);
            user.setId(newKey.intValue());
        } else {
            namedParameterJdbcTemplate.update(
                    "UPDATE users SET name=:name, email=:email, password=:password, " +
                            "phone=:phone, photo=:photo, date_reg=:dateRegistration, " +
                            "role=:role WHERE id=:id", map);
        }
        return user;
    }

    @Override
    public User authorize(String email, String password) throws RepositoryException {
        return null;
    }

    @Override
    public boolean delete(int id) throws RepositoryException {
        return jdbcTemplate.update("DELETE FROM users WHERE id=?", id) != 0;
    }

    @Override
    public User get(int id) throws RepositoryException {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?", ROW_MAPPER, id);
    }

    @Override
    public List<User> getAll(int offset, int count) throws RepositoryException {
        return jdbcTemplate.query("SELECT * FROM users ORDER BY name, email OFFSET ? LIMIT ?", ROW_MAPPER, offset, count);
    }

    @Override
    public List<User> getAll() throws RepositoryException {
        return jdbcTemplate.query("SELECT * FROM users ORDER BY name, email", ROW_MAPPER);
    }

    @Override
    public int checkIfEmailExist(String email) throws RepositoryException {
        return jdbcTemplate.queryForRowSet("SELECT COUNT(1) FROM users WHERE email = ?", email).getInt(1);
    }

    @Override
    public int getCountUsers() throws RepositoryException {
        return jdbcTemplate.queryForRowSet("SELECT COUNT(id) FROM users").getInt(1);
    }
}
