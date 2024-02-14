package com.conservatory.data.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conservatory.data.domain.Instrument;


public interface IInstrumentRepository extends JpaRepository<Instrument, Integer>{

	List<Instrument> findByName(String name);
//	Optional<Instrument> findByInstrumentId(Long instrumentId);
}
