package com.simard.adopteunmonstre.services;

import com.simard.adopteunmonstre.model.entities.MonsterMonsterType;
import com.simard.adopteunmonstre.repository.MonsterMonsterTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonsterMonsterTypeService {
    private final MonsterMonsterTypeRepository monsterMonsterTypeRepository;

    @Autowired
    public MonsterMonsterTypeService(MonsterMonsterTypeRepository monsterMonsterTypeRepository) {
        this.monsterMonsterTypeRepository = monsterMonsterTypeRepository;
    }

    public Iterable<MonsterMonsterType> findAll() {
        return this.monsterMonsterTypeRepository.findAll();
    }

    public MonsterMonsterType create(MonsterMonsterType newMonsterMonsterType) {
        return this.monsterMonsterTypeRepository.save(newMonsterMonsterType);
    }

    public void deleteById(Long id) {
        this.monsterMonsterTypeRepository.deleteById(id);
    }

    public Iterable<MonsterMonsterType> findByMonsterId(Long monsterId) {
        return this.monsterMonsterTypeRepository.findByMonsterId(monsterId);
    }

    public MonsterMonsterType update(Long id, MonsterMonsterType updatedMonsterMonsterType) {
        return monsterMonsterTypeRepository.findById(id)
                .map(monsterMonsterType -> {
                    monsterMonsterType.setMonster(updatedMonsterMonsterType.getMonster());
                    monsterMonsterType.setMonsterType(updatedMonsterMonsterType.getMonsterType());
                    return monsterMonsterTypeRepository.save(monsterMonsterType);
                })
                .orElseThrow(() -> new RuntimeException("MonsterMonsterType not found with id " + id));
    }
}
