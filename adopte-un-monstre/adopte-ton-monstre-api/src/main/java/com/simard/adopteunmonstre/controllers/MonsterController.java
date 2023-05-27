package com.simard.adopteunmonstre.controllers;

import com.simard.adopteunmonstre.mappers.MonsterMapper;
import com.simard.adopteunmonstre.model.entities.Monster;
import com.simard.adopteunmonstre.model.entities.MonsterMonsterType;
import com.simard.adopteunmonstre.model.entities.MonsterType;
import com.simard.adopteunmonstre.model.entities.dto.monster.MonsterDto;
import com.simard.adopteunmonstre.services.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RestController
@RequestMapping("/monster")
public class MonsterController {

    private final MonsterService monsterService;

    @Autowired
    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }

    @GetMapping
    public ResponseEntity<Iterable<MonsterDto>> getAllMonsters() {
        Iterable<Monster> monsters = monsterService.getAllMonsters();
        return ResponseEntity.ok(MonsterMapper.toMonsterDtos((List<Monster>) monsters));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonsterDto> getMonsterById(@PathVariable("id") Long id) {
        Optional<Monster> monster = monsterService.getMonsterById(id);
        return monster.map(value -> ResponseEntity.ok(MonsterMapper.toMonsterDto(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/types")
    public ResponseEntity<Iterable<MonsterDto>> getMonstersByTypes(@RequestBody List<MonsterType> types) {
        Iterable<Monster> monsters = monsterService.findByType(types);
        return ResponseEntity.ok(MonsterMapper.toMonsterDtos((List<Monster>) monsters));
    }

    @PostMapping("/create")
    public ResponseEntity<MonsterDto> createMonster(@RequestBody MonsterDto newMonster) {
        Monster createdMonster = monsterService.create(MonsterMapper.toMonster(newMonster));
        return ResponseEntity.status(HttpStatus.CREATED).body(MonsterMapper.toMonsterDto(createdMonster));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMonster(@PathVariable("id") Long id) {
        monsterService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Iterable<MonsterDto>> getMonstersByUserId(@PathVariable("userId") Long userId) {
        Iterable<Monster> monsters = monsterService.findAllByUserId(userId);
        return ResponseEntity.ok(MonsterMapper.toMonsterDtos((List<Monster>) monsters));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonsterDto> updateMonster(@PathVariable("id") Long id, @RequestBody Monster updatedMonster) {
        Monster updated = monsterService.updateById(id, updatedMonster);
        return ResponseEntity.ok(MonsterMapper.toMonsterDto(updated));
    }
}
