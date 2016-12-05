package by.epam.movieapp.model;

import java.util.Objects;

/**
 * @author Olga Shahray
 */
public class Country {

    private int id;
    private  String country;

    public Country() {
    }

    public Country(int id, String countryName) {
        this.id = id;
        this.country = countryName;
    }

    public Country(String countryName) {
        this.country = countryName;
    }

    public Country(int id) {
        this.id = id;
    }

    public Country(Country country) {
        this(country.getId(), country.getCountry());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String countryName) {
        this.country = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o.getClass() != this.getClass()) return false;
        Country country = (Country) o;
        return id == country.id &&
                Objects.equals(this.country, country.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", country='" + country + '\'' +
                '}';
    }

    public boolean isNew() {
        return id == 0;
    }
}

