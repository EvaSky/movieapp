package by.epam.movieapp.service;

import by.epam.movieapp.model.Country;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static by.epam.movieapp.TestData.COUNTRY;
import static by.epam.movieapp.TestData.COUNTRY_ID;

/**
 * @author Olga Shahray
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql("classpath:db/populateDB.sql")
public class CountryServiceTest {

    @Autowired
    private ICountryService service;

    @Test
    public void testSave() throws Exception {
        Country country = new Country("Germany");
        service.save(country);
        Assert.assertEquals(Arrays.asList(country, COUNTRY), service.getAll());
    }

    @Test
    public void testUpdate() throws Exception {
        Country country = new Country(COUNTRY);
        country.setCountry("Spain");
        service.update(country);
        Assert.assertEquals(country, service.get(COUNTRY_ID));
    }

    @Test
    public void testDelete() throws Exception {
        service.delete(COUNTRY_ID);
        Assert.assertEquals(0, service.getAll().size());
    }

    @Test
    public void testGetAll() throws Exception {
        List<Country> countries = service.getAll();
        Assert.assertEquals(Arrays.asList(COUNTRY), countries);
    }
}