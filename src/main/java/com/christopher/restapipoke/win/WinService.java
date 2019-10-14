package com.christopher.restapipoke.win;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christopher.restapipoke.poke.Poke;

@Service
public class WinService {
	@Autowired
	private WinRepository repository;
	
	
	public List<WinDTO> findAll() {
		List<WinDTO> list = new ArrayList<>();
		repository.findAll().forEach(p -> list.add(p.toDTO()));
		return list;
	}

	public WinDTO find(long id) {
		Optional<Win> p = repository.findById(id);
		return (p.isPresent()) ? p.get().toDTO() : null; // add error 
	}

	public WinDTO save(WinDTO new_poke) {
		return repository.save(new_poke.toModel()).toDTO();
	}

	public WinDTO update(WinDTO poke_change) { // post
		Optional<Win> poke = repository.findById(poke_change.getId());
		if (poke.isPresent()) {
			return save(poke_change); // whole swap
		}
		throw new IllegalArgumentException();
	}

	public void delete(long id) {
		repository.deleteById(id);
	}
	public List<WinDTO> findByVictor(Poke victor) {
		List<WinDTO> list = new ArrayList<>();
		repository.findByVictor(victor).forEach(p -> list.add(p.toDTO()));
		return list;
	}
	public List<WinDTO> findByLoser(Poke loser) {
		List<WinDTO> list = new ArrayList<>();
		repository.findByLoser(loser).forEach(p -> list.add(p.toDTO()));
		return list;
	}

}
