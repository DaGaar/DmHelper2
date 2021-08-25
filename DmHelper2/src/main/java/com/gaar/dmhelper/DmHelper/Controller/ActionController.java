package com.gaar.dmhelper.DmHelper.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaar.dmhelper.DmHelper.Model.Action;
import com.gaar.dmhelper.DmHelper.Service.ActionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1")
public class ActionController {
	
	@Autowired
	private ActionService actionService;
	
	@RequestMapping("/actions")
	public List<Action> getAction() {
		return actionService.findAll();
	}
	
	@PostMapping("/actions")
	public Action createAction(@RequestBody Action action) {
		return actionService.save(action);
	}
	
	@GetMapping("/actions/{id}")
	public ResponseEntity<List<Action>> getActionById(@PathVariable Long id) {
		List<Action> action = actionService.findByAttackerId(id);
		return ResponseEntity.ok(action);
	}
		
	@GetMapping("/charAttacksMade/{id}")
	public ResponseEntity<List<Action>> getActionByAttackerId(@PathVariable Long id) {
		List<Action> actions = actionService.findByAttackerId(id);
		return ResponseEntity.ok(actions);
	}
	
	@GetMapping("/charAttacksRecieved/{id}")
	public ResponseEntity<List<Action>> getActionByAttackedId(@PathVariable Long id) {
		List<Action> actions = actionService.findByAttackedId(id);
		return ResponseEntity.ok(actions);
	}
	
	@GetMapping("/encounterActions/{id}")
	public ResponseEntity<List<Action>> getActionByEncounterId(@PathVariable Long id) {
		List<Action> actions = actionService.findByEncounterId(id);
		return ResponseEntity.ok(actions);
	}	
}
