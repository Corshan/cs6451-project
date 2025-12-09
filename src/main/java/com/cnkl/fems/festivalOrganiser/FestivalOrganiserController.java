package com.cnkl.fems.festivalOrganiser;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/festival_organiser")
public class FestivalOrganiserController {

    private final FestivalOrganiserService festivalOrganiserService;

    public FestivalOrganiserController(FestivalOrganiserService festivalOrganiserService){
        this.festivalOrganiserService = festivalOrganiserService;
    }

    @GetMapping
    public List<FestivalOrganiser> getAllFestivalOrganiser(){
        return this.festivalOrganiserService.getAllFestivalOrganiser();
    }
}
