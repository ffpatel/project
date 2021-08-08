package com.gameOfThrones.got;

public class BattleResponse {

	
	public String name;
	public String year;
	public String battle_number;
	public String attacker_king;
	public String defender_king;
	public String attacker_1;
	public String attacker_2;
	public String attacker_3;
	public String attacker_4;
	public String defender_1;
	public String defender_2;
	public String defender_3;
	public String defender_4;
	public String attacker_outcome;
	public String battle_type;
	public String major_death;
	public String major_capture;
	public String attacker_size;
	public String defender_size;
	public String attacker_commander;
	public String defender_commander;
	public String summer;
	public String location;
	public String region;
	public String note;
	
	public BattleResponse() {
		super();
	}

	public BattleResponse(String name, String year, String battle_number, String attacker_king, String defender_king,
			String attacker_1, String attacker_2, String attacker_3, String attacker_4, String defender_1,
			String defender_2, String defender_3, String defender_4, String attacker_outcome, String battle_type,
			String major_death, String major_capture, String attacker_size, String defender_size,
			String attacker_commander, String defender_commander, String summer, String location, String region,
			String note) {
		super();
		this.name = name;
		this.year = year;
		this.battle_number = battle_number;
		this.attacker_king = attacker_king;
		this.defender_king = defender_king;
		this.attacker_1 = attacker_1;
		this.attacker_2 = attacker_2;
		this.attacker_3 = attacker_3;
		this.attacker_4 = attacker_4;
		this.defender_1 = defender_1;
		this.defender_2 = defender_2;
		this.defender_3 = defender_3;
		this.defender_4 = defender_4;
		this.attacker_outcome = attacker_outcome;
		this.battle_type = battle_type;
		this.major_death = major_death;
		this.major_capture = major_capture;
		this.attacker_size = attacker_size;
		this.defender_size = defender_size;
		this.attacker_commander = attacker_commander;
		this.defender_commander = defender_commander;
		this.summer = summer;
		this.location = location;
		this.region = region;
		this.note = note;
	}

	
	
	
}
