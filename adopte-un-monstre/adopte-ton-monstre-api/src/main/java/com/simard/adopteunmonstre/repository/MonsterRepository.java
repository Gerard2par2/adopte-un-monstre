package com.simard.adopteunmonstre.repository;

import com.simard.adopteunmonstre.model.entities.Monster;
import com.simard.adopteunmonstre.model.entities.MonsterType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonsterRepository extends CrudRepository<Monster, Long> {
    List<Monster> findByType(MonsterType type);
}
