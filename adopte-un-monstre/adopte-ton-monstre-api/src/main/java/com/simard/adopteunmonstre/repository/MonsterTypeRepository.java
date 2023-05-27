package com.simard.adopteunmonstre.repository;

import com.simard.adopteunmonstre.model.entities.MonsterType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonsterTypeRepository extends CrudRepository<MonsterType, Long> {
}
