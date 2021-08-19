package com.tperuch.hrpayroll.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class PaymentProperties {

    @Value("${hr-worker.host}")
    public String workerUrl;
}
