package com.conservatory.business.interfaces;

import java.util.List;

import com.conservatory.data.domain.Instrument;

public interface IInstrumentService {

	List<Instrument> getAllInstruments();
	Instrument findById(Integer id);
	Instrument createInstrument(Instrument instrument);
	void deleteInstrument(Integer id);
	
	
}
