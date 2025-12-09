package com.cnkl.fems.festival;

import com.cnkl.fems.ticket.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/festival")
public class FestivalController {

    private final FestivalService festivalService;

    @Autowired
    FestivalController(FestivalService festivalService) {
        this.festivalService = festivalService;
    }

    @PostMapping
    public ResponseEntity<?> addFestival(@RequestBody Festival festival){
        try{
            return ResponseEntity.ok(festivalService.createFestival(festival));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<FestivalDto> getAllFestivals(){
        return festivalService.getAllFestivals();
    }

    @GetMapping("/{id}/purchase_ticket")
    public ResponseEntity<?> purchaseTicket(@PathVariable long id, @RequestParam long customer_id){
        try {
           return ResponseEntity.ok(festivalService.purchaseTicket(id, customer_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}/open")
    public ResponseEntity<?> updateStateOpen(@PathVariable long id){
        try{
            festivalService.openFestival(id);
            return ResponseEntity.ok("Festival now open");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}/close")
    public ResponseEntity<?> updateStateClose(@PathVariable long id){
        try{
            festivalService.closeFestival(id);
            return ResponseEntity.ok("Festival now close");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
