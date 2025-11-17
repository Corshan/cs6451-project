package com.cnkl.fems.user.festivalOrganiser;

import com.cnkl.fems.festival.Festival;
import com.cnkl.fems.user.User;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("FES_ORG")
public class FestivalOrganiser extends User {
    private List<Festival> festivals;

    public FestivalOrganiser(User user) {
        super(user);
        this.festivals = new ArrayList<>();
    }

    public FestivalOrganiser() {

    }

    public List<Festival> getFestivals() {
        return festivals;
    }

    public void setFestivals(List<Festival> festivals) {
        this.festivals = festivals;
    }
}
