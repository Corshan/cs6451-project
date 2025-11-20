package com.cnkl.fems.festival;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Stall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int stallNumber;
    private String companyName;
    private String stallType;

    public Stall (Long id, int stallNumber, String companyName, String stallType) {
        this.id = id;
        this.stallNumber = stallNumber;
        this.companyName = companyName;
        this.stallType = stallType;
    }

    public Long getId () {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
