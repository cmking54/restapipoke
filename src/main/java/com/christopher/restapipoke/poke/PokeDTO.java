package com.christopher.restapipoke.poke;

import java.util.Set;

import com.christopher.restapipoke.win.Win;

public class PokeDTO {
	private long id;
	private String name;
	private String type1; // different type
	private String type2;
	private String type3;
	private int hp; // stats
	private int attack;
	private int defense;
	private int sp_attack;
	private int sp_defense;
	private int speed;
	private Set<Win> wins;
	private Set<Win> losses;
	public PokeDTO() {}
	public PokeDTO(long id, String name, String type1, String type2, String type3, int hp, int attack, int defense, int sp_attack,
			int sp_defense, int speed) {
		this.id = id; 
		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
		this.type3 = type3;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.sp_attack = sp_attack;
		this.sp_defense = sp_defense;
		this.speed = speed;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	public String getType3() {
		return type3;
	}
	public void setType3(String type3) {
		this.type3 = type3;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getSp_attack() {
		return sp_attack;
	}
	public void setSp_attack(int sp_attack) {
		this.sp_attack = sp_attack;
	}
	public int getSp_defense() {
		return sp_defense;
	}
	public void setSp_defense(int sp_defense) {
		this.sp_defense = sp_defense;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public Set<Win> getWins() {
		return wins;
	}
	public PokeDTO setWins(Set<Win> wins) {
		this.wins = wins;
		return this;
	}
	public Set<Win> getLosses() {
		return losses;
	}
	public PokeDTO setLosses(Set<Win> losses) {
		this.losses = losses;
		return this;
	}
	public Poke toModel() {
		return new Poke(id, name, type1, type2, 
				type3, hp, attack, defense, sp_attack,
				sp_defense, speed);
	}
	@Override
	public String toString() {
		return "PokeDTO [id=" + id + ", name=" + name + ", type1=" + type1 + ", type2=" + type2 + ", type3=" + type3
				+ ", hp=" + hp + ", attack=" + attack + ", defense=" + defense + ", sp_attack=" + sp_attack
				+ ", sp_defense=" + sp_defense + ", speed=" + speed + ", wins=" + wins + ", losses=" + losses + "]";
	}
}
