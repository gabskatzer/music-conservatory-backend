package com.conservatory.data.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conservatory.data.domain.Commissioned;

@Repository
public interface ICommissionerRepository extends JpaRepository<Commissioned, Integer>{

}
