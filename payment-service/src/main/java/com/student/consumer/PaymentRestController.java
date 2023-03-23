package com.student.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentRestController {
    @Autowired
    private CartRestConsumer consumer; //HAS-A

    @Value("${server.port}")
    private String port;

    @GetMapping("/data")
    public String getPaymentData(){
        return "FROM PAYMENT-SERVICE : " + consumer.getCartInfo();
    }

    @GetMapping("/info")
    public ResponseEntity<String> showPaymentInfo(){
        return ResponseEntity.ok("FROM PAYMENT-SERVICE, PORT# IS: " + port);
    }

}
