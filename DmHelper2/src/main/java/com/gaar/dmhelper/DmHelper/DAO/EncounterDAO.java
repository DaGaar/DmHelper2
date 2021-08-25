package com.gaar.dmhelper.DmHelper.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaar.dmhelper.DmHelper.Model.Encounter;

public interface EncounterDAO extends JpaRepository<Encounter, Long> {

}
