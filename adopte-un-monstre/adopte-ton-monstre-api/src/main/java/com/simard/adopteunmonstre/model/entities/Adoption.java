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

    public Long getId() {
        return id;
    }

    public Date getAdoptionDate() {
        return adoptionDate;
    }

    public Monster getMonster() {
        return monster;
    }

    public String getMonsterState() {
        return monsterState;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAdoptionDate(Date adoptionDate) {
        this.adoptionDate = adoptionDate;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public void setMonsterState(String monsterState) {
        this.monsterState = monsterState;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
