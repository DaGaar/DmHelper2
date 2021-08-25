insert into pc(id, name, max_hp, current_hp) 
	values (101, 'Baldwin Dasher', 30, 5);
insert into pc(id, name, max_hp, current_hp) 
	values (102, 'Naome', 25, 20);
insert into pc(id, name, max_hp, current_hp) 
	values (103, 'San Foldin', 18, 2);
insert into pc(id, name, max_hp, current_hp) 
	values (104, 'Tom Bimbles', 23, 20);
	
insert into pc(id, name, max_hp, current_hp) 
	values (301, 'Matted Mohawk', 15, 15);
insert into pc(id, name, max_hp, current_hp) 
	values (302, 'lazy eye', 15, 13);
insert into pc(id, name, max_hp, current_hp) 
	values (303, 'Buff n armored', 42, 27);
insert into pc(id, name, max_hp, current_hp) 
	values (304, 'Limping Caster', 45, 36);

insert into encounter(id, name) values (101, 'Betrayal');
insert into encounter(id, name) values (102, 'GoblinParty');
insert into encounter(id, name) values (103, 'orcsWithHostages');
insert into encounter(id, name) values (104, 'BossBattle');

insert into action(encounter_id, id, type, attacker_id, attacked_id, dmg_done, effect)
	values (101, 1, 'attack', 101, 104, 0, 'prone');
insert into action(encounter_id, id, type, attacker_id, attacked_id, dmg_done, effect) 
	values (101, 2, 'attack', 101, 103, 12, 'disarm');
insert into action(encounter_id, id, type, attacker_id, attacked_id, dmg_done)
	values (101, 3, 'attack', 102, 101, 3);
insert into action(encounter_id, id, type, attacker_id, attacked_id, dmg_done)
	values (101, 4, 'attack', 103, 104, 0);
insert into action(encounter_id, id, type, attacker_id, attacked_id, dmg_done)
	values (101, 5, 'attack', 102, 104, 20);
insert into action(encounter_id, id, type, attacker_id, attacked_id, dmg_done, effect)
	values (101, 6, 'attack', 104, 103, 5, 'prone');
insert into action(encounter_id, id, type, attacker_id, attacked_id, dmg_done)
	values (101, 8, 'attack', 103, 102, 6);
insert into action(encounter_id, id, type, attacker_id, attacked_id, dmg_done)
	values (101, 9, 'attack', 103, 101, 0);
insert into action(encounter_id, id, type, attacker_id, attacked_id, dmg_done)
	values (101, 10, 'attack', 103, 104, 0);
insert into action(encounter_id, id, type, attacker_id, attacked_id, dmg_done, effect)
	values (101, 11, 'attack', 104, 103, 2, 'shove');
insert into action(encounter_id, id, type, attacker_id, attacked_id, dmg_done)
	values (101, 12, 'attack', 102, 101, 0);