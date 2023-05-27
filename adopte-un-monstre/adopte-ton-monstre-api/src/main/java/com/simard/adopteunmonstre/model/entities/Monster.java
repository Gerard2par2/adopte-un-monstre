package com.simard.adopteunmonstre.model.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Monster {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "monster")
    private List<MonsterMonsterType> monsterMonsterTypes;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MonsterMonsterType> getMonsterMonsterTypes() {
        return monsterMonsterTypes;
    }

    public void setMonsterMonsterTypes(List<MonsterMonsterType> monsterMonsterTypes) {
        this.monsterMonsterTypes = monsterMonsterTypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Monster monster)) return false;
        return Objects.equals(getId(), monster.getId()) && Objects.equals(getName(), monster.getName()) && Objects.equals(getDescription(), monster.getDescription()) && Objects.equals(getMonsterMonsterTypes(), monster.getMonsterMonsterTypes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getMonsterMonsterTypes());
    }

    @Override
    public String toString() {
        return "Monster{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", monsterMonsterTypes=" + monsterMonsterTypes +
                '}';
    }
}
