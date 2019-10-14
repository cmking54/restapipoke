package com.christopher.restapipoke.move;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoveService {
	@Autowired
	private MoveRepository repository;
	
	
	public List<MoveDTO> findAll() {
		List<MoveDTO> list = new ArrayList<>();
		repository.findAll().forEach(p -> list.add(p.toDTO()));
		return list;
	}

	public MoveDTO find(long id) {
		Optional<Move> p = repository.findById(id);
		return (p.isPresent()) ? p.get().toDTO() : null; // add error 
	}

	public MoveDTO save(MoveDTO new_poke) {
		return repository.save(new_poke.toModel()).toDTO();
	}

	public MoveDTO update(MoveDTO poke_change) { // post
		Optional<Move> poke = repository.findById(poke_change.getId());
		if (poke.isPresent()) {
			return save(poke_change); // whole swap
		}
		throw new IllegalArgumentException();
	}

	public void delete(long id) {
		repository.deleteById(id);
	}

}
