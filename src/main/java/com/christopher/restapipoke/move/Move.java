package com.christopher.restapipoke.move;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Move {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private int accuracy;
	private int power;
	private int pp;
	@NotBlank(message="The Move Must Have A Move")
	private String name;
	@NotBlank(message="The Move Must Have A Type")
	private String type;
	
	public Move() {}
	
	public Move(long id, int accuracy, int power, int pp, String name, String type) {
		this.id = id;
		this.accuracy = accuracy;
		this.power = power;
		this.pp = pp;
		this.name = name;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getPp() {
		return pp;
	}

	public void setPp(int pp) {
		this.pp = pp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public MoveDTO toDTO() {
		return new MoveDTO(id, accuracy, power, pp, name, type);
	}
}
