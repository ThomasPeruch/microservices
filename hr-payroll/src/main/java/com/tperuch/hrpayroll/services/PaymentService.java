package com.tperuch.hrpayroll.services;

import com.tperuch.hrpayroll.entities.Payment;
import com.tperuch.hrpayroll.entities.Worker;
import com.tperuch.hrpayroll.feignclients.WorkerFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentService {

    private WorkerFeignClient feignClient;

    public Payment getPayment(Long workerId, Integer daysOfWork) {
        Worker worker = feignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), daysOfWork);
    }
}
