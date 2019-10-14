package com.christopher.restapipoke.win;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.christopher.restapipoke.poke.Poke;

@Entity
public class Win {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JoinColumn(name = "victor_id")
	private Poke victor;
	@ManyToOne
	@JoinColumn(name = "loser_id")
	private Poke loser;
//	private long victor_id;
//	private long loser_id;
	private int critical_win; // -1 for favored by level, 0 for same level, 1 for unfavored
	public Win() {}
	
	public Win(long id, Poke victor, Poke loser, int critical_win) {
		this.id = id;
		this.victor = victor;
		this.loser = loser;
		this.critical_win = critical_win;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Poke getVictor() {
		return victor;
	}

	public void setVictor(Poke victor) {
		this.victor = victor;
	}

	public Poke getLoser() {
		return loser;
	}

	public void setLoser(Poke loser) {
		this.loser = loser;
	}

	public int getCritical_win() {
		return critical_win;
	}

	public void setCritical_win(int critical_win) {
		this.critical_win = critical_win;
	}

	public WinDTO toDTO() {
		return new WinDTO(id, victor, loser, critical_win);
	}
}
