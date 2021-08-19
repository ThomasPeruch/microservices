package com.tperuch.hrpayroll.rest;

import com.tperuch.hrpayroll.entities.Payment;
import com.tperuch.hrpayroll.entities.Worker;
import com.tperuch.hrpayroll.properties.PaymentProperties;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor
public class PaymentRestService {

    private RestTemplate restTemplate;
    private PaymentProperties properties;

    public Worker getPayment(String workerId){
        return restTemplate.getForObject(
                properties.getWorkerUrl().concat(workerId),
                Worker.class,
                getUriVariables(workerId));
    }


    private Map<String,String> getUriVariables(String workerId){
        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("id",String.valueOf(workerId));
        return uriVariables;
    }
}
