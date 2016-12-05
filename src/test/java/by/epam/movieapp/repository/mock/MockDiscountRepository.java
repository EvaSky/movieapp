package by.epam.movieapp.repository.mock;

import by.epam.movieapp.model.Discount;
import by.epam.movieapp.repository.IDiscountRepository;
import by.epam.movieapp.repository.exception.RepositoryException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Olga Shahray
 */
@Repository
public class MockDiscountRepository implements IDiscountRepository{
    @Override
    public void save(Discount discount) throws RepositoryException {

    }

    @Override
    public Discount getUserDiscount(int userId) throws RepositoryException {
        return null;
    }

    @Override
    public boolean delete(int discountId) throws RepositoryException {
        return false;
    }

    @Override
    public List<Discount> getAll() throws RepositoryException {
        return null;
    }

    @Override
    public Discount get(int id) throws RepositoryException {
        return null;
    }
}
