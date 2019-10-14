package com.christopher.restapipoke.poke;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christopher.restapipoke.win.WinDTO;

@Service
public class PokeService {
	@Autowired
	private PokeRepository repository;
	
	
	public List<PokeDTO> findAll() {
		return StreamSupport.stream(repository.findAll().spliterator(), false).map(p -> p.toDTO()).collect(Collectors.toList());
	}

	public PokeDTO find(long id) {
		return repository.findById(id).orElseThrow().toDTO();
	}

	public PokeDTO save(PokeDTO new_poke) {
		return repository.save(new_poke.toModel()).toDTO();
	}

	public PokeDTO update(PokeDTO poke_change) { // post
		return save(repository.findById(poke_change.getId()).orElseThrow().toDTO());
	}

	public void delete(long id) {
		repository.deleteById(id);
	}
	public List<WinDTO> getWins(long id) {
		System.out.println(find(id));
		return toStream(find(id).getWins()).map(w -> w.toDTO()).collect(Collectors.toList());
	}
	public List<WinDTO> getLosses(long id) {
		return toStream(find(id).getLosses()).map(w -> w.toDTO()).collect(Collectors.toList());
	}
	private <P> Stream<P> toStream(Collection<? extends P> collection) {
		return new ArrayList<P>(collection).stream();
	}

}
