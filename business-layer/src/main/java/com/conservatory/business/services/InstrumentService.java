package com.conservatory.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conservatory.business.interfaces.IInstrumentService;
import com.conservatory.data.domain.Instrument;
import com.conservatory.data.interfaces.IInstrumentRepository;

@Service
public class InstrumentService implements IInstrumentService{
	
	@Autowired
	private IInstrumentRepository instrumentRepository;

	@Override
	public List<Instrument> getAllInstruments() {
		return instrumentRepository.findAll();
	}

	@Override
	public Instrument findById(Integer id) {
		return instrumentRepository.getReferenceById(id);
	}

	@Override
	public Instrument createInstrument(Instrument instrument) {
		return instrumentRepository.save(instrument);
	}

}
