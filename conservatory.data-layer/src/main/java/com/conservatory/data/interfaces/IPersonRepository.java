package com.conservatory.data.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conservatory.data.domain.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer>{

}
