package com.simard.adopteunmonstre.services;

import com.simard.adopteunmonstre.exception.ResourceNotFoundException;
import com.simard.adopteunmonstre.model.entities.Monster;
import com.simard.adopteunmonstre.model.entities.MonsterMonsterType;
import com.simard.adopteunmonstre.model.entities.MonsterType;
import com.simard.adopteunmonstre.repository.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonsterService {
    private final MonsterRepository monsterRepository;

    @Autowired
    public MonsterService(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }

    public Iterable<Monster> getAllMonsters() {
        return this.monsterRepository.findAll();
    }

    public Optional<Monster> getMonsterById(Long id) {
        return this.monsterRepository.findById(id);
    }

    public Iterable<Monster> findByType(List<MonsterType> types) {
        return this.monsterRepository.findByMonsterMonsterTypes(types);
    }

    public Monster create(Monster newMonster) {
        return this.monsterRepository.save(newMonster);
    }

    public void deleteById(Long id) {
        this.monsterRepository.deleteById(id);
    }

    public Iterable<Monster> findAllByUserId(Long userId) {
        return this.monsterRepository.findAllByUserId(userId);
    }

    public Monster updateById(Long id, Monster updatedMonster) {
        return monsterRepository.findById(id)
                .map(monster -> {
                    monster.setName(updatedMonster.getName());
                    monster.setDescription(updatedMonster.getDescription());
                    monster.setMonsterMonsterTypes(updatedMonster.getMonsterMonsterTypes());
                    return monsterRepository.save(monster);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Monster not found with id " + id));
    }

}
