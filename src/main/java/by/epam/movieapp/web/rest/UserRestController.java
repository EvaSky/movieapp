package by.epam.movieapp.web.rest;

import by.epam.movieapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author Olga Shahray
 */
@Controller
public class UserRestController {

    @Autowired
    private IUserService userService;
}
