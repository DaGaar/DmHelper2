package com.gaar.dmhelper.DmHelper.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gaar.dmhelper.DmHelper.Model.Npc;
import com.gaar.dmhelper.DmHelper.Service.NpcService;

@Controller
@RequestMapping("api/v1")
public class NpcController {

	@Autowired
	private NpcService npcService;
	
	@GetMapping("npcForm")
	public String npcForm() {
		System.out.println("inside NpcController npcForm()");
		return "npc.html";
	}
	
	@GetMapping("npcs")
	public String getNpcs(Model model) {
		List<Npc> npcs = npcService.findAll();
		model.addAttribute("npcs", npcs);
		System.out.println("inside NpcController getNpcs()");
		return "EncounterOccupants.html";
	}
	
	@GetMapping("addNpc")
	public String addNpc(Npc npc) {
		npcService.saveAndFlush(npc);
		System.out.println("inside NpcController addNpc");
		return "npc.html";
	}
}
