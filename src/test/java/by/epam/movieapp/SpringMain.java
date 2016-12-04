package by.epam.movieapp;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author Olga Shahray
 */
public class SpringMain {
    public static void main(String[] args) {
        try(ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/mock.xml")){
            System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
            /*UserServiceImpl service = context.getBean(UserServiceImpl.class);
            System.out.println(service.getUserRepository());*/
        }
    }
}
