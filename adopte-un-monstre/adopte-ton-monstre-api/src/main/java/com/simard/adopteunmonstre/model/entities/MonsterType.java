package com.simard.adopteunmonstre.model.entities;

import jakarta.persistence.*;

import java.util.List;

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
}
