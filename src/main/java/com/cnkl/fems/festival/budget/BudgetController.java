package com.cnkl.fems.festival.budget;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/budget")
public class BudgetController {

    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }


    @PostMapping
    public ResponseEntity<Budget> initializeBudget(@RequestBody Map<String, BigDecimal> request) {
        BigDecimal totalAmount = request.get("amount");
        if (totalAmount == null || totalAmount.compareTo(BigDecimal.ZERO) < 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Budget budget = budgetService.initializeBudget(totalAmount);
        return new ResponseEntity<>(budget, HttpStatus.CREATED);
    }


    @GetMapping("/amount")
    public ResponseEntity<Map<String, BigDecimal>> getBudgetAmount() {
        return budgetService.getGlobalBudget()

                .map(budget -> ResponseEntity.ok(Map.of("amount", budget.getAmount())))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/remaining")
    public ResponseEntity<Map<String, BigDecimal>> getRemainingBudget() {
        try {
            BigDecimal remaining = budgetService.getRemainingBudget();
            return ResponseEntity.ok(Map.of("remainingBudget", remaining));
        } catch (RuntimeException e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

