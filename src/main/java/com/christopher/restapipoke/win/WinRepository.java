package com.christopher.restapipoke.win;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.christopher.restapipoke.poke.Poke;

@Repository
public interface WinRepository extends CrudRepository<Win, Long> {
	public List<Win> findByVictor(Poke victor);
	public List<Win> findByLoser(Poke loser);
	public List<Win> findByVictorId(long victor_id); // which will work
	public List<Win> findByLoserId(long loser_id);
}
