package com.cnkl.fems.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentTypeService {
    private PaymentTypeRepository paymentTypeRepository;
    @Autowired
    public PaymentTypeService(PaymentTypeRepository paymentTypeRepository) {
        this.paymentTypeRepository = paymentTypeRepository;
    }
    public List<PaymentType> getAllPaymentTypes() {
        return paymentTypeRepository.findAll();
    }
    public Optional<PaymentType> getPaymentTypeById(Long id) {
        return paymentTypeRepository.findById(id);
    }
    public PaymentType createPaymentType(PaymentType paymentType) {
        return paymentTypeRepository.save(paymentType);
    }
    public void deletePaymentTypeById(Long id) {
        paymentTypeRepository.deleteById(id);
    }
}