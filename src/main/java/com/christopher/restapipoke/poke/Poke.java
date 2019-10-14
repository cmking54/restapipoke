package com.christopher.restapipoke.poke;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.christopher.restapipoke.win.Win;

@Entity
public class Poke {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column @NotBlank(message="The Pokemon Must Have A Name")
	private String name;
	@Column @NotBlank(message="The Pokemon Must Have A Type")
	private String type1; // different type
	@Column
	private String type2;
	@Column
	private String type3;
	@Column 
	private int hp; // stats
	@Column
	private int attack;
	@Column
	private int defense;
	@Column
	private int sp_attack;
	@Column
	private int sp_defense;
	@Column
	private int speed;
	@OneToMany(mappedBy = "victor")
	Set<Win> wins;
	@OneToMany(mappedBy = "loser")
	Set<Win> losses;
	public Poke() {}
	public Poke(long id, String name, String type1, String type2, String type3, int hp, int attack, int defense, int sp_attack,
			int sp_defense, int speed) {
		this.id = id;
		System.out.println("Constructor: " + this.id);
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
		System.out.println("Id Set: " + id);
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
	public PokeDTO toDTO() {
		return new PokeDTO(id, name, type1, type2, 
				type3, hp, attack, defense, sp_attack,
				sp_defense, speed).setWins(wins).setLosses(losses);
	}
}
