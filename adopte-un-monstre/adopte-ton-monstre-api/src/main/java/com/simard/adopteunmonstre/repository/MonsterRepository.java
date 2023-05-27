package com.simard.adopteunmonstre.repository;

import com.simard.adopteunmonstre.model.entities.Monster;
import com.simard.adopteunmonstre.model.entities.MonsterMonsterType;
import com.simard.adopteunmonstre.model.entities.MonsterType;
import jakarta.persistence.JoinColumn;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonsterRepository extends CrudRepository<Monster, Long> {
    @Query("SELECT m FROM Monster m where m.id = (select a.monster.id from Adoption a where a.user.id = :userId) ")
    List <Monster> findAllByUserId(Long userId);

    @Query("SELECT m FROM Monster m where m.id in (select mmt.monster.id from MonsterMonsterType mmt where mmt.monsterType in :monsterMonsterTypes)")
    List<Monster> findByMonsterMonsterTypes(List<MonsterMonsterType> monsterMonsterTypes);

}
