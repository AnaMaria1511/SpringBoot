package com.example.SpringBootUdemy.repository;

import com.example.SpringBootUdemy.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {

    //conect to database
    @PersistenceContext
    EntityManager entityManager;

    public Person findById (int id){
        return entityManager.find(Person.class, id);
    }

    public Person insert(Person person){
        return entityManager.merge(person);
    }

    public void deleteById(int id){
        Person person=findById(id);
        entityManager.remove(person);
    }

    public List<Person> findAll(){
        TypedQuery<Person> nameQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return nameQuery.getResultList();
    }

}
