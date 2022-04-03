package com.odcode.eureka.service;


import com.odcode.client.FraudCheckResponse;
import com.odcode.client.FraudClient;
import com.odcode.client.NotificationClient;
import com.odcode.client.NotificationRequest;
import com.odcode.eureka.model.Customer;
import com.odcode.eureka.repository.CustomerRepository;
import com.odcode.eureka.model.CustomerRegistrationRequest;
import com.odcode.notification.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    private FraudClient fraudClient;

    private NotificationClient client;


    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest){
        Customer customer= Customer.builder().

                firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email()).build();

        customerRepository.saveAndFlush(customer);

        //FraudCheckResponse fraudCheckResponse= restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}", FraudCheckResponse.class,customer.getId());

        FraudCheckResponse fraudCheckResponse= fraudClient.isFraudster(customer.getId());

        client.registerNotification(new NotificationRequest(
                customer.getId(),customer.getEmail(),"Welcome"+customer.getFirstName()
                ));






//        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://FRAUD/isfrauster/{customerId}", FraudCheckResponse.class, customer.getId());
//
        if(fraudCheckResponse.isFraudSter()) {
            throw new IllegalStateException("Customer is a fraudster");

        }

    }

}
