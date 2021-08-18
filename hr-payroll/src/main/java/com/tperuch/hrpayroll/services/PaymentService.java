package com.tperuch.hrpayroll.services;

import com.tperuch.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, Integer daysOfWork){
        return new Payment("Bob", 100.0, daysOfWork);
    }
}
