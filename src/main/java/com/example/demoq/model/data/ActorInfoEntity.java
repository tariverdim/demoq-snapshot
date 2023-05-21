package com.example.demoq.model.data;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "actor_info", schema = "sakila")
public class ActorInfoEntity {
    @Basic
    @Id
    @GeneratedValue
    @Column(name = "actor_id")
    private Long actorId;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "film_info")
    private String filmInfo;

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFilmInfo() {
        return filmInfo;
    }

    public void setFilmInfo(String filmInfo) {
        this.filmInfo = filmInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorInfoEntity that = (ActorInfoEntity) o;
        return Objects.equals(actorId, that.actorId) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(filmInfo, that.filmInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, firstName, lastName, filmInfo);
    }
}
