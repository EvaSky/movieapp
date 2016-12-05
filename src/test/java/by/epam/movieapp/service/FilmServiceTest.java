package by.epam.movieapp.service;

import by.epam.movieapp.model.Film;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static by.epam.movieapp.TestData.*;

/**
 * @author Olga Shahray
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql("classpath:db/populateDB.sql")
public class FilmServiceTest {

    @Autowired
    private IFilmService service;

    @Test
    public void testSave() throws Exception {
        Film film = new Film("6 film", 2016, COUNTRY, "Plot", 100, 12, 10.0, "poster.jpg", "video.hd");
        service.save(film);
        Assert.assertEquals(Arrays.asList(FILM1, FILM2, film), service.getAll());
    }

    @Test
    public void testUpdate() throws Exception {
        Film film = new Film(FILM1);
        film.setTitle("Updated");
        service.update(film);
        Assert.assertEquals(film, service.get(FILM1_ID));
    }

    @Test
    public void testGet() throws Exception {
        Film film = service.get(FILM1_ID);
        Assert.assertEquals(FILM1, film);
    }

    @Test
    public void testDelete() throws Exception {
        service.delete(FILM1_ID);
        Assert.assertEquals(Collections.singletonList(FILM2), service.getAll());
    }

    @Test
    public void testGetAll() throws Exception {
        List<Film> films = service.getAll();
        Assert.assertEquals(Arrays.asList(FILM1, FILM2), films);
    }
}