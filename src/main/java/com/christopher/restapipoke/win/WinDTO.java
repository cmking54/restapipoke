package com.christopher.restapipoke.win;

import com.christopher.restapipoke.poke.Poke;

public class WinDTO {
	private long id;
	private Poke victor;
	private Poke loser;
	private long victor_id;
	private long loser_id;
	private int critical_win; // -1 for favored by level, 0 for same level, 1 for unfavored
	
	public WinDTO() {}
	
	public WinDTO(long id, Poke victor, Poke loser, int critical_win) {
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

	public long getVictor_id() {
		return victor_id;
	}

	public void setVictor_id(long victor_id) {
		this.victor_id = victor_id;
	}

	public long getLoser_id() {
		return loser_id;
	}

	public void setLoser_id(long loser_id) {
		this.loser_id = loser_id;
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

	public Win toModel() {
		return new Win(id, victor, loser, critical_win);
	}
}
