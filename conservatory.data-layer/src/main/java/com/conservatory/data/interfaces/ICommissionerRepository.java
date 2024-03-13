package com.conservatory.data.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conservatory.data.domain.Commissioned;

@Repository
public interface ICommissionerRepository extends JpaRepository<Commissioned, Integer>{

	Long deleteByPersonId(Integer personId);
	Optional<Commissioned> getByPersonId(Integer personId);

}
