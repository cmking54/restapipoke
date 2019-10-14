package com.christopher.restapipoke.poke;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.christopher.restapipoke.poke.PokeDTO;
import com.christopher.restapipoke.poke.PokeService;
import com.christopher.restapipoke.win.WinDTO;

@RestController
@RequestMapping("/api")
public class PokeController {
	@Autowired
	private PokeService service;
	@GetMapping("/pokes")
	public ResponseEntity<List<PokeDTO>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/pokes/{id}")
	public ResponseEntity<PokeDTO> find(@PathVariable String id) {
		return ResponseEntity.ok(service.find(Long.valueOf(id)));
	}
	
	@PostMapping("/pokes")
	public ResponseEntity<PokeDTO> create(@RequestBody @Valid PokeDTO new_poke) throws URISyntaxException {
		PokeDTO result = service.save(new_poke);
		return ResponseEntity.created(new URI("/api/pokes/" + result.getId())).body(result);
	}
	
	@PutMapping("/pokes")
	public ResponseEntity<PokeDTO> update(@RequestBody @Valid PokeDTO updated_poke) {
		PokeDTO result = service.update(updated_poke);
		return ResponseEntity.ok().body(result);
	}
	
	@DeleteMapping("/pokes/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(Long.valueOf(id));
		return ResponseEntity.ok().build();
	}
	@GetMapping("/pokes/{id}/wins")
	public ResponseEntity<List<WinDTO>> getWinsOf(@PathVariable String id) {
		return ResponseEntity.ok(service.getWins(Long.valueOf(id))); // error handling needed
	}
	@GetMapping("/pokes/{id}/losses")
	public ResponseEntity<List<WinDTO>> getLossesOf(@PathVariable String id) {
		return ResponseEntity.ok(service.getLosses(Long.valueOf(id))); // error handling needed
	}
}
