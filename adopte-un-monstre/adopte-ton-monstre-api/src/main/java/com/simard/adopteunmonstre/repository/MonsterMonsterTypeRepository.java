package com.simard.adopteunmonstre.repository;

import com.simard.adopteunmonstre.model.entities.MonsterMonsterType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonsterMonsterTypeRepository extends CrudRepository<MonsterMonsterType, Long> {
    public Iterable<MonsterMonsterType> findByMonsterId(Long monsterId);
}
