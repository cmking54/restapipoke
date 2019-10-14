package com.christopher.restapipoke.win;

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



@RestController
@RequestMapping("/api")
public class WinController {
	@Autowired
	private WinService service;
	@Autowired
	private PokeService pokeService;
	@GetMapping("/wins")
	public ResponseEntity<List<WinDTO>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/wins/{id}")
	public ResponseEntity<WinDTO> find(@PathVariable String id) {
		return ResponseEntity.ok(service.find(Long.valueOf(id)));
	}
	
	@PostMapping("/wins")
	public ResponseEntity<WinDTO> create(@RequestBody @Valid WinDTO new_win) throws URISyntaxException {
		WinDTO result = service.save(new_win);
		return ResponseEntity.created(new URI("/api/wins/" + result.getId())).body(result);
	}
	
	@PutMapping("/wins")
	public ResponseEntity<WinDTO> update(@RequestBody @Valid WinDTO updated_win) {
		WinDTO result = service.update(updated_win);
		return ResponseEntity.ok().body(result);
	}
	
	@DeleteMapping("/wins/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(Long.valueOf(id));
		return ResponseEntity.ok().build();
	}
	
}
