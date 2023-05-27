package com.simard.adopteunmonstre.repository;

import com.simard.adopteunmonstre.model.entities.Monster;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonsterRepository extends CrudRepository<Monster, Long> {
}
