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

    @ElementCollection
    private List<String> strengths;

    @ElementCollection
    private List<String> weaknesses;

    public List<String> getWeaknesses() {
        return weaknesses;
    }

    public List<String> getStrengths() {
        return strengths;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setWeaknesses(List<String> weaknesses) {
        this.weaknesses = weaknesses;
    }

    public void setStrengths(List<String> strengths) {
        this.strengths = strengths;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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
