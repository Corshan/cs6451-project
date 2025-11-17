package com.cnkl.fems.Payment;

public class CreditCardPayment extends PaymentType {
    public CreditCardPayment(String type) {
        super(type);
    }
    @Override
    public void process() {
        System.out.println("Processing credit card payment...");
    }
}