package com.simard.adopteunmonstre.mappers;

import com.simard.adopteunmonstre.model.entities.Monster;
import com.simard.adopteunmonstre.model.entities.MonsterMonsterType;
import com.simard.adopteunmonstre.model.entities.MonsterType;
import com.simard.adopteunmonstre.model.entities.dto.monster.MonsterDto;

import java.util.ArrayList;
import java.util.List;

public class MonsterMapper {
    private MonsterMapper() {
        // Constructeur privé pour empêcher l'instanciation de la classe
    }

    public static MonsterDto toMonsterDto(Monster monster) {
        List<MonsterType> types = new ArrayList<>(monster.getMonsterMonsterTypes().size());
        monster.getMonsterMonsterTypes().forEach(monsterMonsterType -> types.add(monsterMonsterType.getMonsterType()));
        return new MonsterDto(monster.getId(), monster.getName(), monster.getDescription(), types);
    }

    public static Monster toMonster(MonsterDto monsterDto) {
        Monster monster = new Monster();
        monster.setName(monsterDto.getName());
        monster.setDescription(monsterDto.getDescription());
        monster.setMonsterMonsterTypes(new ArrayList<>(monsterDto.getTypes().stream().map(monsterType -> new MonsterMonsterType(monster, monsterType)).toList()));
        return monster;
    }

    public static List<MonsterDto> toMonsterDtos(List<Monster> monsters) {
        return new ArrayList<>(monsters.stream().map(MonsterMapper::toMonsterDto).toList());
    }
}
