package com.christopher.restapipoke.poke;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokeRepository extends CrudRepository<Poke, Long> {

}
