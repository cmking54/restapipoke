package com.christopher.restapipoke.move;

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


@RestController
@RequestMapping("/api")
public class MoveController {
	@Autowired
	private MoveService service;
	@GetMapping("/moves")
	public ResponseEntity<List<MoveDTO>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/moves/{id}")
	public ResponseEntity<MoveDTO> find(@PathVariable String id) {
		return ResponseEntity.ok(service.find(Long.valueOf(id)));
	}
	
	@PostMapping("/moves")
	public ResponseEntity<MoveDTO> create(@RequestBody @Valid MoveDTO new_move) throws URISyntaxException {
		MoveDTO result = service.save(new_move);
		return ResponseEntity.created(new URI("/api/moves/" + result.getId())).body(result);
	}
	
	@PutMapping("/moves")
	public ResponseEntity<MoveDTO> update(@RequestBody @Valid MoveDTO updated_move) {
		MoveDTO result = service.update(updated_move);
		return ResponseEntity.ok().body(result);
	}
	
	@DeleteMapping("/moves/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(Long.valueOf(id));
		return ResponseEntity.ok().build();
	}
}
