package com.cnkl.fems.payment;

import com.cnkl.fems.notification.NotificationService;
import com.cnkl.fems.ticket.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final NotificationService notificationService;  
    @Autowired
    public PaymentService(PaymentRepository paymentRepository, NotificationService notificationService) {
        this.paymentRepository = paymentRepository;
        this.notificationService = notificationService;
    }
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
    public void deletePaymentById(Long id) {
        paymentRepository.deleteById(id);
    }
    public Payment processSuccessfulPayment(Payment payment, Ticket ticket) {
        Payment savedPayment = paymentRepository.save(payment);
        notificationService.notifyTicketPurchased(ticket);
        return savedPayment;
    }
}