package com.gaar.dmhelper.DmHelper.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaar.dmhelper.DmHelper.DAO.NpcDAO;
import com.gaar.dmhelper.DmHelper.Model.Npc;

@Service
public class NpcService {
	
	@Autowired
	private NpcDAO npcDAO;
	
	public List<Npc> findAll() {
		System.out.println("inside NpcService findAll");
		return npcDAO.findAll();
	}
	
	public Npc saveAndFlush(Npc npc) {
		System.out.println("inside NpcService saveAndFlush");
		return npcDAO.saveAndFlush(npc);
	}

}
