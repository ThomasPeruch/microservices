package com.tperuch.hrpayroll.services;

import com.tperuch.hrpayroll.models.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, Integer days){
         return new Payment("Cris", 500.0, days);
    }

}
