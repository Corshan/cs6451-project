 package com.cnkl.fems.budget;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
@Entity
public class Budget {
    @Id
    private Long id = 1L; // Ensures a single global budget

    private BigDecimal amount; // Total budget amount
    private BigDecimal expenditure; // Current money spent

    public Budget() {
        this.amount = BigDecimal.ZERO;
        this.expenditure = BigDecimal.ZERO;
    }

    // Core Business Rule
    public boolean isValidTransaction(BigDecimal transactionCost) {
        return this.expenditure.add(transactionCost).compareTo(this.amount) <= 0;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id)
    {
        this.id = id;
    }

    public BigDecimal getAmount()
    { return amount;
    }
    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public BigDecimal getExpenditure()
    {
        return expenditure;
    }
    public void setExpenditure(BigDecimal expenditure) {
        this.expenditure = expenditure;
    }
}

