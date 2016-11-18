package by.epam.movieapp;

/**
 * @author Olga Shahray
 */
public class Main {
    private static final LoggerWrapper LOG = LoggerWrapper.get(Main.class);

    public static void main(String[] args) {
        LOG.debug("before");
        System.out.println("In main");
        LOG.debug("after");
    }
}
