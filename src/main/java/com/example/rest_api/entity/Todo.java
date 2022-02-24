package com.example.rest_api.entity;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id;
    private Duration Timeofcreate;
    private String name;
    private String Owner;

    private boolean Status = Boolean.FALSE;

    public Todo() {
    }

    public Todo(Long id, Duration timeofcreate, String name, String owner, boolean status) {
        this.id = id;
        Timeofcreate = timeofcreate;
        this.name = name;
        Owner = owner;
        Status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Duration getTimeofcreate() {
        return Timeofcreate;
    }

    public void setTimeofcreate(Duration timeofcreate) {
        Timeofcreate = timeofcreate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public boolean isStatus() {
        return Status;
    }

    public boolean setStatus(boolean status) {
        Status = status;
        return status;
    }
}
