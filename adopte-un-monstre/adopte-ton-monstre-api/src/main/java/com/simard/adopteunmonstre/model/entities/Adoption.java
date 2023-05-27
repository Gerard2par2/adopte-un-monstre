package com.simard.adopteunmonstre.model.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Adoption {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="monster_id", nullable=false)
    private Monster monster;

    private Date adoptionDate;
    private String monsterState;

    // getters and setters...
}
