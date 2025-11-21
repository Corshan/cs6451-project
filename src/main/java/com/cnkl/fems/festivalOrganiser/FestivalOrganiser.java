package com.cnkl.fems.festivalOrganiser;

import com.cnkl.fems.festival.Festival;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class FestivalOrganiser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date dob;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "festivalOrganiser")
    private List<Festival> festivals;

    public FestivalOrganiser() {

    }

    public List<Festival> getFestivals() {
        return festivals;
    }

    public void setFestivals(List<Festival> festivals) {
        this.festivals = festivals;
    }
}
