package com.cnkl.fems.festival.stall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StallService {

    private StallRepository stallRepository;

    @Autowired
    public StallService(StallRepository stallRepository) {
        this.stallRepository = stallRepository;
    }

    public List<Stall> getAllStalls() {
        return stallRepository.findAll();
    }

    public Optional<Stall> getStallById(Long id) {
        return stallRepository.findById(id);
    }

    public Stall createStall(Stall stall) {
        return stallRepository.save(stall);
    }

    public void deleteStallById(Long id) {
        stallRepository.deleteById(id);
    }
}
