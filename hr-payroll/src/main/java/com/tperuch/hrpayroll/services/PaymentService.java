package com.tperuch.hrpayroll.services;

import com.tperuch.hrpayroll.entities.Payment;
import com.tperuch.hrpayroll.entities.Worker;
import com.tperuch.hrpayroll.rest.PaymentRestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentService {

    private PaymentRestService restService;

    public Payment getPayment(Long workerId, Integer daysOfWork) {
        Worker worker = restService.getPayment(String.valueOf(workerId));
        return new Payment(worker.getName(), worker.getDailyIncome(), daysOfWork);


    }
}
