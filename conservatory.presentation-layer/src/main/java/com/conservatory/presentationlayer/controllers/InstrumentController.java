package com.conservatory.presentationlayer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@Autowired
	private IInstrumentService instrumentService;
	
	@GetMapping
	public List<Instrument> getAllInstruments(){
		List<Instrument> instruments = instrumentService.getAllInstruments();
		return instruments;
		
	}
	
	@Transactional
	@PostMapping
	public  Instrument createInstrument(@RequestBody Instrument instrument) {
		return instrumentService.createInstrument(instrument);
	}
	
	@DeleteMapping("/{id}")
	public void deletePerson(@PathVariable Integer id) {
		instrumentService.deleteInstrument(id);
	}
}
