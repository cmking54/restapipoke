package com.christopher.restapipoke.move;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoveRepository extends CrudRepository<Move, Long> {

}
