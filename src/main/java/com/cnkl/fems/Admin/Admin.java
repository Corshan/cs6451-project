package com.cnkl.fems.Admin;

import com.cnkl.fems.Festival.Festival;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import java.util.List;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    private List<Festival> festivals;
    public Admin(String name, List<Festival> festivals) {
        this.name = name;
        this.festivals = festivals;
    }
    public Admin() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Festival> getFestivals() {
        return festivals;
    }
    public void setFestivals(List<Festival> festivals) {
        this.festivals = festivals;
    }
    public void manageFestival(Festival festival) {
        festivals.add(festival);
    }
}