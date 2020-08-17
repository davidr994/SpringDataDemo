package de.david.databasedemo;

import de.david.databasedemo.entity.Person;
import de.david.databasedemo.jpa.PersonJpaRepository;
import de.david.databasedemo.springdata.PersonSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringDataDemo implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonSpringDataRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataDemo.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("User id 1001 -> {}", repository.findById(1001));
        logger.info("Inserting 1004 -> {}", repository.save(new Person(1004,
                "Ivan",
                "New York",
                new Date())));
        repository.deleteById(1002);
        logger.info("All users -> {}", repository.findAll());

        /*

        logger.info("User name 'Ruri' -> {}", repository.findByName("Ruri"));
         */

    }
}
