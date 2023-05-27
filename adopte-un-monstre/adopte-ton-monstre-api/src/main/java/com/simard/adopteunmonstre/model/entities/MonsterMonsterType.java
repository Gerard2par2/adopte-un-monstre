package com.simard.adopteunmonstre.model.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class MonsterMonsterType {

    public MonsterMonsterType(Monster monster, MonsterType monsterType) {
        this.monster = monster;
        this.monsterType = monsterType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Monster monster;

    @ManyToOne
    private MonsterType monsterType;

    public MonsterMonsterType() {
        this(null, null);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Monster getMonster() {
        return monster;
    }

    public MonsterType getMonsterType() {
        return monsterType;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public void setMonsterType(MonsterType monsterType) {
        this.monsterType = monsterType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MonsterMonsterType that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getMonster(), that.getMonster()) && Objects.equals(getMonsterType(), that.getMonsterType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMonster(), getMonsterType());
    }

    @Override
    public String toString() {
        return "MonsterMonsterType{" +
                "id=" + id +
                ", monster=" + monster +
                ", monsterType=" + monsterType +
                '}';
    }
}
