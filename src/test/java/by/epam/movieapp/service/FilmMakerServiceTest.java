package by.epam.movieapp.service;

import by.epam.movieapp.model.FilmMaker;
import by.epam.movieapp.model.Profession;
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
public class FilmMakerServiceTest {

    @Autowired
    private IFilmMakerService service;

    @Test
    public void testSave() throws Exception {
        FilmMaker filmMaker = new FilmMaker("J.Depp", Profession.ACTOR);
        service.save(filmMaker);
        Assert.assertEquals(Arrays.asList(ACTOR, DIRECTOR, filmMaker), service.getAll());
    }

    @Test
    public void testUpdate() throws Exception {
        FilmMaker filmMaker = new FilmMaker(ACTOR);
        filmMaker.setName("UpdatedActor");
        service.update(filmMaker);
        Assert.assertEquals(filmMaker, service.get(ACTOR_ID));
    }

    @Test
    public void testDelete() throws Exception {
        service.delete(ACTOR_ID);
        Assert.assertEquals(Collections.singletonList(DIRECTOR), service.getAll());
    }

    @Test
    public void testGet() throws Exception {
        FilmMaker filmMaker = service.get(ACTOR_ID);
        Assert.assertEquals(ACTOR, filmMaker);
    }

    @Test
    public void testGetAll() throws Exception {
        List<FilmMaker> filmMakerList = service.getAll();
        Assert.assertEquals(Arrays.asList(ACTOR, DIRECTOR), filmMakerList);
    }
}