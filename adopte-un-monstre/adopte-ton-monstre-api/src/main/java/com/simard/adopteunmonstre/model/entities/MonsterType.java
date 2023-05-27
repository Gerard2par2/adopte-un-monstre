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

    // getters and setters...
}
