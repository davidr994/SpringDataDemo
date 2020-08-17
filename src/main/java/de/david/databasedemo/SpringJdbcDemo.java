package de.david.databasedemo;

import de.david.databasedemo.entity.Person;
import de.david.databasedemo.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class SpringJdbcDemo implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    PersonJdbcDao dao;

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcDemo.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All users -> {}", dao.findAll());
        logger.info("User id 1001 -> {}", dao.findById(1001));
        logger.info("User name 'Ruri' -> {}", dao.findByName("Ruri"));
        logger.info("Deleting id 1003 -> No of Rows Deleted - {}", dao.deleteById(1003));
        logger.info("Inserting 1004 -> {}", dao.insert(new Person(1004,
                "Ivan",
                "New York",
                new Date())));

    }
}
