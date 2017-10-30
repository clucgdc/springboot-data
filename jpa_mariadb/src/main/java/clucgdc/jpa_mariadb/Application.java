package clucgdc.jpa_mariadb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author Cam Luc
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        repository.deleteAll();

        User john = new User("John", "john@yahoo.com");
        User jack = new User("Jack", "jack@gmail.com");

        repository.save(john);
        repository.save(jack);

        System.out.println("User count: " + repository.count());
        System.out.println("Users start with J: " + repository.findByNameStartingWith("j").size());
        System.out.println("Users with Gmail: " + repository.findByEmailEndingWith("gmail.com").size());
    }
}
