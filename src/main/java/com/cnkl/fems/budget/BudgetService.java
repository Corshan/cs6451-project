
package com.cnkl.fems.budget;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;


    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public Optional<Budget> getGlobalBudget() {
        return budgetRepository.findById(1L);
    }


    public boolean canCommitExpense(BigDecimal cost) {
        Budget budget = getGlobalBudget().orElse(new Budget());
        return budget.isValidTransaction(cost);
    }


    public void commitExpense(BigDecimal cost) {
        Budget budget = getGlobalBudget().orElseThrow(() -> new RuntimeException("Budget not set."));
        budget.setExpenditure(budget.getExpenditure().add(cost));
        budgetRepository.save(budget);
    }


    public Budget initializeBudget(BigDecimal totalAmount) {
        Budget budget = getGlobalBudget().orElse(new Budget());
        budget.setAmount(totalAmount);
        return budgetRepository.save(budget);
    }


    public BigDecimal getRemainingBudget() {
        Budget budget = getGlobalBudget().orElseThrow(() -> new RuntimeException("Budget not set."));
        return budget.getAmount().subtract(budget.getExpenditure());
    }
}