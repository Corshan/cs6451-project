package com.cnkl.fems.festival.stall;

import java.util.ArrayList;
import java.util.List;

public class StallGroup implements StallComponent{

    private String name;
    private List<StallComponent> stalls  = new ArrayList<>();

    public StallGroup(String name) {
        this.name = name;
    }

    public void add(StallComponent stall) {
        stalls.add(stall);
    }

    public void remove(StallComponent stall) {
        stalls.remove(stall);
    }

    public List<StallComponent> getChildren() {
        return stalls;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void display() {
        System.out.println("Stall Group: " + name);
        for (StallComponent stall : stalls) {
            stall.display();
        }
    }
}
