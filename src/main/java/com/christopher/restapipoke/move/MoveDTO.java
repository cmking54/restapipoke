package com.christopher.restapipoke.move;

public class MoveDTO {
	private long id;
	private int accuracy;
	private int power;
	private int pp;
	private String name;
	private String type;
	
	public MoveDTO() {}
	
	public MoveDTO(long id, int accuracy, int power, int pp, String name, String type) {
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

	public Move toModel() {
		return new Move(id, accuracy, power, pp, name, type);
	}
}
