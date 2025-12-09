package com.cnkl.fems.festivalOrganiser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FestivalOrganiserService {

    private final FestivalOrganiserRepository festivalOrganiserRepository;

    @Autowired
    public FestivalOrganiserService(FestivalOrganiserRepository festivalOrganiserRepository){
        this.festivalOrganiserRepository = festivalOrganiserRepository;
    }

    public List<FestivalOrganiser> getAllFestivalOrganiser(){
        return festivalOrganiserRepository.findAll();
    }
}
