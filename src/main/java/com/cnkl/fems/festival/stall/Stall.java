package com.cnkl.fems.festival.stall;

import com.cnkl.fems.festival.Festival;
import jakarta.persistence.*;

@Entity
public class Stall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int stallNumber;
    private String companyName;
    private String stallType;

    @ManyToOne
    @JoinColumn(name = "festival_id")
    private Festival festival;

    public Stall() {}

    public Stall (int stallNumber, String companyName, String stallType, Festival festival) {
        this.stallNumber = stallNumber;
        this.companyName = companyName;
        this.stallType = stallType;
        this.festival = festival;
    }

    public Long getId () {
        return id;
    }

    public int getStallNumber () {
        return stallNumber;
    }

    public void setStallNumber(int stallNumber) {
        this.stallNumber = stallNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStallType() {
        return stallType;
    }

    public void setStallType(String stallType) {
        this.stallType = stallType;
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }
}