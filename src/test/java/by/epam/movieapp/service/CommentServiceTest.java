package by.epam.movieapp.service;

import by.epam.movieapp.model.Comment;
import by.epam.movieapp.model.CommentStatus;
import by.epam.movieapp.service.exception.ServiceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static by.epam.movieapp.TestData.*;
import static by.epam.movieapp.UserTestData.USER_ID;

/**
 * @author Olga Shahray
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql("classpath:db/populateDB.sql")
public class CommentServiceTest {

    @Autowired
    private ICommentService service;

    @Before
    public void setUp() throws ServiceException {
        COMMENT1.setDateComment(service.get(COMMENT1_ID, FILM1_ID, USER_ID).getDateComment());
        COMMENT2.setDateComment(service.get(COMMENT2_ID, FILM1_ID, USER_ID).getDateComment());
    }

    @Test
    public void testSave() throws Exception {
        Comment comment = new Comment(0, 5, "nice!", CommentStatus.NEW);
        service.save(comment, FILM1_ID, USER_ID);
        Assert.assertEquals(new ArrayList<>(Arrays.asList(comment, COMMENT2, COMMENT1)), service.getAllOfUser(USER_ID));
    }

    @Test
    public void testDelete() throws Exception {
        service.delete(COMMENT1_ID, FILM1_ID, USER_ID);
        Assert.assertEquals(Collections.singletonList(COMMENT2), service.getAllOfUser(USER_ID));
    }

    @Test
    public void testGetAllOfUser() throws Exception {
        List<Comment> comments = service.getAllOfUser(USER_ID);
        Assert.assertEquals(Arrays.asList(COMMENT2, COMMENT1), comments);
    }
}