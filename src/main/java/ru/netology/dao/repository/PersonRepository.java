package ru.netology.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.dao.entity.Person;
import ru.netology.dao.entity.PersonsPK;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonsPK> {

    List<Person> findPersonByCityOfLiving(String city);

    List<Person> findAllByPersonsPK_AgeLessThanOrderByPersonsPK_ageAsc(Long age);

    Optional<Person> findPersonByPersonsPK_NameAndPersonsPK_Surname(String name, String surname);

}


