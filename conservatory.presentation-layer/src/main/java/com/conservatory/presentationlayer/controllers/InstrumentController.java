package com.conservatory.presentationlayer.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conservatory.business.interfaces.IInstrumentService;
import com.conservatory.data.domain.Instrument;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/instrument")
public class InstrumentController {

	private IInstrumentService instrumentService;
	
	public List<Instrument> getAllInstruments(){
		List<Instrument> instruments = instrumentService.getAllInstruments();
		return instruments;
		
	}
	
	@Transactional
	@PostMapping
	public  Instrument createInstrument(@RequestBody Instrument instrument) {
		return instrumentService.createInstrument(instrument);
	}
}
