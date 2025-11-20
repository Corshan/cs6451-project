package com.cnkl.fems.payment;

import com.cnkl.fems.notification.Notification;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isVerified;
    @ManyToOne
    private Notification notification;
    private int amountOfTickets;
    @ManyToOne
    private PaymentType paymentType;
    public Payment(boolean isVerified, Notification notification, int amountOfTickets, PaymentType paymentType) {
        this.isVerified = isVerified;
        this.notification = notification;
        this.amountOfTickets = amountOfTickets;
        this.paymentType = paymentType;
    }
    public Payment() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public boolean isVerified() {
        return isVerified;
    }
    public void setVerified(boolean verified) {
        isVerified = verified;
    }
    public Notification getNotification() {
        return notification;
    }
    public void setNotification(Notification notification) {
        this.notification = notification;
    }
    public int getAmountOfTickets() {
        return amountOfTickets;
    }
    public void setAmountOfTickets(int amountOfTickets) {
        this.amountOfTickets = amountOfTickets;
    }
    public PaymentType getPaymentType() {
        return paymentType;
    }
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}