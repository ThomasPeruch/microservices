package com.tperuch.hrpayroll.services;

import com.tperuch.hrpayroll.feignclients.WorkerFeignClient;
import com.tperuch.hrpayroll.models.Payment;
import com.tperuch.hrpayroll.models.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(Long workerId, Integer days) {
        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
