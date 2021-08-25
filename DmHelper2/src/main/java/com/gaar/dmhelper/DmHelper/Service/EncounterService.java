package com.gaar.dmhelper.DmHelper.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaar.dmhelper.DmHelper.DAO.EncounterDAO;
import com.gaar.dmhelper.DmHelper.Model.Encounter;
import com.gaar.dmhelper.DmHelper.Model.Pc;

import Exception.ResourceNotFoundException;


@Service
public class EncounterService {
	
	@Autowired 
	private EncounterDAO encounterDAO;
	
	public List<Encounter> findAll() {
		return encounterDAO.findAll();
	}
	
	public Encounter save(Encounter combat) {
		return encounterDAO.saveAndFlush(combat);
	}
	
	public Encounter findById(Long id) {
		return encounterDAO.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("encounter not "
						+ "found with id: " + id));
	}
	
	
	public void delete(Encounter encounter) {
		encounterDAO.delete(encounter);
	}

}
