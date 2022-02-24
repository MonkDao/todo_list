package com.example.rest_api.entity;

import javax.persistence.*;

@Entity
@Table(name = "rolles")
public class Rolles{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rolles_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private static Rolles role;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Rolles() {
    }

    public Rolles(Rolles role, User user) {
        this.role = role;
        this.user = user;
    }

    public Long getId(long l) {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static Rolles getRole() {
        return role;
    }

    public void setRole(Rolles role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Rolles{" +
                "id=" + id +
                ", role=" + role +
                '}';
    }

}
