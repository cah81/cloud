package com.student.consumer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CartRestConsumer {
    @Autowired
    DiscoveryClient discoveryClient;

    public String serviceUrl(){
        List<ServiceInstance> list = discoveryClient.getInstances("CART-SERVICE");
        if(list !=null && list.size()>0){
            ServiceInstance serviceInstance = list.get(0);
            return serviceInstance.getUri()+ "/cart/getData";
        }
        return null;

    }

    public String getCartInfo(){
        // get ServiceInstance list using serviceId
        //List<ServiceInstance> list = discoveryClient.getInstances("CART-SERVICE");
        // read manually one instance from index#0
        //ServiceInstance serviceInstance = list.get(0);
        // read URI and Add path that returns url
        //String url = serviceInstance.getUri() + "cart/getData";
        // create object for RestTemplate
        RestTemplate rt = new RestTemplate();
        // make HTTP call and get Reponse data
        String response = rt.getForObject(serviceUrl(),String.class);
        // return response back to Consumer
        return response;
    }

}
