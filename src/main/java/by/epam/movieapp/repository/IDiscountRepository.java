package by.epam.movieapp.repository;

import by.epam.movieapp.model.Discount;
import by.epam.movieapp.repository.exception.RepositoryException;

import java.util.List;

/**
 * @author Olga Shahray
 */
public interface IDiscountRepository {

    void save(Discount discount) throws RepositoryException;

    void update(Discount discount) throws RepositoryException;

    Discount getUserDiscount(int userId)  throws RepositoryException;

    // false if not found
    boolean delete(int discountId) throws RepositoryException;

    List<Discount> getAll() throws RepositoryException;


}
