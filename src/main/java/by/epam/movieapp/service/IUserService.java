package by.epam.movieapp.service;


import by.epam.movieapp.model.User;
import by.epam.movieapp.service.exception.ServiceException;

import java.util.List;

/**
 * @author Olga Shahray
 */
public interface IUserService {
    //CRUD
    User save(User user) throws ServiceException;

    User get(int id) throws ServiceException;

    void delete(int id) throws ServiceException;

    List<User> getAll() throws ServiceException;

    //other
    User authorize(String login, String password) throws ServiceException;

    //PagingListDTO<User> getAll(int offset, int count) throws ServiceException;

    int checkEmail(String email) throws ServiceException;

    void updateUserPass(User loggedUser, String newPass, String confirmPass)throws ServiceException;
}
