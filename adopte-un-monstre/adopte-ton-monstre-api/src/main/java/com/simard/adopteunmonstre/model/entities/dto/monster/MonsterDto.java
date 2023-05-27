package com.simard.adopteunmonstre.model.entities.dto.monster;

import com.simard.adopteunmonstre.model.entities.MonsterType;

import java.util.List;

public class MonsterDto {

    public MonsterDto(Long id, String name, String description, List<MonsterType> types) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.types = types;
    }
    private final Long id;
    private final String name;
    private final String description;
    private List<MonsterType> types;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<MonsterType> getTypes() {
        return types;
    }

    public void setTypes(List<MonsterType> types) {
        this.types = types;
    }
}
