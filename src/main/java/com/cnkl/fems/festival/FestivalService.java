package com.cnkl.fems.festival;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FestivalService {

    private FestivalRepository festivalRepository;

    @Autowired
    public FestivalService(FestivalRepository festivalRepository) {
        this.festivalRepository = festivalRepository;
    }

    public List<Festival> getAllFestivals() {
        return festivalRepository.findAll();
    }

    public Optional<Festival> getFestivalById(Long id) {
        return festivalRepository.findById(id);
    }

    public Festival createFestival(Festival festival) {
        return festivalRepository.save(festival);
    }

    public void deleteFestivalById(Long id) {
        festivalRepository.deleteById(id);
    }
}
