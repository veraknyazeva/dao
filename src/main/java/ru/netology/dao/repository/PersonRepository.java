package ru.netology.dao.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ru.netology.dao.entity.Person;

import java.util.List;

@Repository
@Slf4j
public class PersonRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Person> getPersonsByCity(String city) {
        List<Person> personList = entityManager.createQuery("SELECT p FROM Person p WHERE LOWER(p.cityOfLiving) = :city", Person.class)
                .setParameter("city", city.toLowerCase())
                .getResultList();
        return personList;
    }
}
