package de.david.databasedemo.springdata;

import de.david.databasedemo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonSpringDataRepository
        extends JpaRepository <Person, Integer> {
}
