package com.cnkl.fems.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/paymentType")
public class PaymentTypeController {
    @Autowired
    private PaymentTypeService paymentTypeService;
    @GetMapping
    public List<PaymentType> getAllPaymentTypes(){
        return paymentTypeService.getAllPaymentTypes();
    }
}