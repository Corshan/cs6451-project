package com.cnkl.fems.festival.stall;

public class StallLeaf implements StallComponent{

    private final Stall stall;

    public StallLeaf(Stall stall) {
        this.stall = stall;
    }

    @Override
    public String getName() {
        return stall.getCompanyName();
    }

    @Override
    public void display() {
        System.out.println("Stall: " + stall.getCompanyName());
    }

    public Stall getStall() {
        return stall;
    }
}
