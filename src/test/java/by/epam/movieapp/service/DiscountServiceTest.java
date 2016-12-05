package by.epam.movieapp.service;

import by.epam.movieapp.model.Discount;
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
public class DiscountServiceTest {

    @Autowired
    private IDiscountService service;

    @Test
    public void testSave() throws Exception {
        Discount discount = new Discount(100.0, 10.0);
        service.save(discount);
        Assert.assertEquals(Arrays.asList(DISCOUNT1, DISCOUNT2, discount), service.getAll());
    }

    @Test
    public void testUpdate() throws Exception {
        Discount discount = new Discount(DISCOUNT1);
        discount.setValue(1.0);
        service.update(discount);
        Assert.assertEquals(discount, service.get(DISCOUNT1_ID));
    }

    @Test
    public void testGetDiscount() throws Exception {
        Discount discount = service.get(DISCOUNT1_ID);
        Assert.assertEquals(DISCOUNT1, discount);
    }

    @Test
    public void testDelete() throws Exception {
        service.delete(DISCOUNT1_ID);
        Assert.assertEquals(Collections.singletonList(DISCOUNT2), service.getAll());
    }

    @Test
    public void testGetAll() throws Exception {
        List<Discount> discounts = service.getAll();
        Assert.assertEquals(Arrays.asList(DISCOUNT1, DISCOUNT2), discounts);
    }
}