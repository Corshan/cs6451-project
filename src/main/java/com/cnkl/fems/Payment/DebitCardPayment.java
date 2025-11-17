package com.cnkl.fems.Payment;

public class DebitCardPayment extends PaymentType {
    public DebitCardPayment(String type) {
        super(type);
    }
    @Override
    public void process() {
        System.out.println("Processing debit card payment...");
    }
}