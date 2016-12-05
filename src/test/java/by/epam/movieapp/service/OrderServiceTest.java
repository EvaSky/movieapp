package by.epam.movieapp.service;

import by.epam.movieapp.model.Order;
import by.epam.movieapp.model.OrderStatus;
import by.epam.movieapp.service.exception.ServiceException;
import org.junit.Assert;
import org.junit.Before;
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
public class OrderServiceTest {

    @Autowired
    private IOrderService service;

    @Before
    public void setUp() throws ServiceException {
        ORDER.setDateSale(service.get(ORDER_ID, FILM1_ID, USER_ID).getDateSale());
    }

    @Test
    public void testSave() throws Exception {
        Order order = new Order(10.0, OrderStatus.PAID);
        service.save(order, FILM2_ID, USER_ID);
        Assert.assertEquals(Arrays.asList(order, ORDER), service.getAll());
    }

    @Test
    public void testUpdate() throws Exception {
        Order order = new Order(ORDER);
        order.setStatus(OrderStatus.UNPAID);
        service.update(order, FILM1_ID, USER_ID);
        Assert.assertEquals(order, service.get(ORDER_ID, FILM1_ID, USER_ID));
    }

    @Test
    public void testDelete() throws Exception {
        service.delete(ORDER_ID, FILM1_ID, USER_ID);
        Assert.assertEquals(0, service.getAll().size());
    }

    @Test
    public void testGet() throws Exception {
        Order order = service.get(ORDER_ID, FILM1_ID, USER_ID);
        Assert.assertEquals(ORDER, order);
    }

    @Test
    public void testGetAll() throws Exception {
        Assert.assertEquals(Collections.singletonList(ORDER), service.getAll());
    }

    @Test
    public void testGetUserOrdersByStatus() throws Exception {
        List<Order> orders = service.getUserOrdersByStatus(USER_ID, OrderStatus.PAID);
        Assert.assertEquals(Collections.singletonList(ORDER),orders);
    }
}