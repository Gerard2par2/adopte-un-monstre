package com.simard.adopteunmonstre.model.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class MonsterType {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany
    private List<MonsterType> strengths;

    @ManyToMany
    private List<MonsterType> weaknesses;

    @OneToMany(mappedBy = "monsterType")
    private List<MonsterMonsterType> monsterMonsterTypes;

    public List<MonsterType> getWeaknesses() {
        return weaknesses;
    }

    public List<MonsterType> getStrengths() {
        return strengths;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setWeaknesses(List<MonsterType> weaknesses) {
        this.weaknesses = weaknesses;
    }

    public void setStrengths(List<MonsterType> strengths) {
        this.strengths = strengths;
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
        if (!(o instanceof MonsterType that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getStrengths(), that.getStrengths()) && Objects.equals(getWeaknesses(), that.getWeaknesses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getStrengths(), getWeaknesses());
    }

    @Override
    public String toString() {
        return "MonsterType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", strengths=" + strengths +
                ", weaknesses=" + weaknesses +
                '}';
    }
}
