package com.cnkl.fems.festival;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/festival")
public class FestivalController {

    @Autowired
    private FestivalService festivalService;

    @GetMapping
    public List<Festival> getAllFestivals(){
        return festivalService.getAllFestivals();
    }
}
