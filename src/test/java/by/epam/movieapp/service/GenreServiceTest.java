package by.epam.movieapp.service;

import by.epam.movieapp.model.Genre;
import by.epam.movieapp.service.exception.ServiceException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
public class GenreServiceTest {

    @Autowired
    private IGenreService service;

    @Test
    public void testSave() throws ServiceException {
        Genre newGenre = new Genre("comedy");
        Genre savedGenre = service.save(newGenre);
        newGenre.setId(savedGenre.getId());
        Assert.assertEquals(Arrays.asList(GENRE1, GENRE2, newGenre), service.getAll());
    }

    @Test
    public void testUpdate() throws ServiceException {
        Genre updatedGenre = new Genre(GENRE1);
        updatedGenre.setGenreName("UpdatedName");
        service.update(updatedGenre);
        Assert.assertEquals(updatedGenre, service.get(GENRE1_ID));
    }

    @Test(expected = DataAccessException.class)
    public void testDublicateSave() throws ServiceException {
        Genre genreDuplicate = new Genre("action6");
        service.save(genreDuplicate);
    }

    @Test
    public void testDelete() throws ServiceException {
        service.delete(GENRE1_ID);
        Assert.assertEquals(Collections.singletonList(GENRE2), service.getAll());
    }

    @Test
    public void testGet() throws ServiceException {
        Genre genre = service.get(GENRE1_ID);
        Assert.assertEquals(GENRE1, genre);
    }

    @Test
    public void testGetAll() throws ServiceException {
        List<Genre> allGenres = service.getAll();
        Assert.assertEquals(Arrays.asList(GENRE1, GENRE2), allGenres);
    }
}
