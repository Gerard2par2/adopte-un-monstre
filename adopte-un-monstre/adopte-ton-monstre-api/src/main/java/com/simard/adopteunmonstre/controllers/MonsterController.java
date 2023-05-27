package com.simard.adopteunmonstre.controllers;

import com.simard.adopteunmonstre.model.entities.Monster;
import com.simard.adopteunmonstre.model.entities.MonsterMonsterType;
import com.simard.adopteunmonstre.services.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/monster")
public class MonsterController {

    private final MonsterService monsterService;

    @Autowired
    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Monster>> getAllMonsters() {
        Iterable<Monster> monsters = monsterService.getAllMonsters();
        return ResponseEntity.ok(monsters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monster> getMonsterById(@PathVariable("id") Long id) {
        Optional<Monster> monster = monsterService.getMonsterById(id);
        return monster.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/types")
    public ResponseEntity<Iterable<Monster>> getMonstersByTypes(@RequestBody List<MonsterMonsterType> types) {
        Iterable<Monster> monsters = monsterService.findByType(types);
        return ResponseEntity.ok(monsters);
    }

    @PostMapping("/create")
    public ResponseEntity<Monster> createMonster(@RequestBody Monster newMonster) {
        Monster createdMonster = monsterService.create(newMonster);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMonster);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMonster(@PathVariable("id") Long id) {
        monsterService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Iterable<Monster>> getMonstersByUserId(@PathVariable("userId") Long userId) {
        Iterable<Monster> monsters = monsterService.findAllByUserId(userId);
        return ResponseEntity.ok(monsters);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Monster> updateMonster(@PathVariable("id") Long id, @RequestBody Monster updatedMonster) {
        Monster updated = monsterService.updateById(id, updatedMonster);
        return ResponseEntity.ok(updated);
    }
}
