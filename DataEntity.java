package com.gameOfThrones.got;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity.BodyBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@ToString
@Table(name = "battle_info")
public class DataEntity {
	@Id
	private String battle_number;
	private String name;
	private String year;
	private String attacker_king;
	private String defender_king;
	private String attacker_1;
	private String attacker_2;
	private String attacker_3;
	private String attacker_4;
	private String defender_1;
	private String defender_2;
	private String defender_3;
	private String defender_4;
	private String attacker_outcome;
	private String battle_type;
	private String major_death;
	private String major_capture;
	private String attacker_size;
	private String defender_size;
	private String attacker_commander;
	private String defender_commander;
	private String summer;
	private String location;
	private String region;
	private String note;
	
	public DataEntity() {};
	
	public DataEntity(String name, String year, String battle_number, String attacker_king, String defender_king,
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

	public static DataEntity body(String message) {
		return null;
	}

	public static BodyBuilder status(HttpStatus expectationFailed) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
