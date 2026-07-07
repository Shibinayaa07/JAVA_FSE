package com.cognizant.orderservice;

import com.cognizant.orderservice.model.CustomerOrder;
import com.cognizant.orderservice.repository.CustomerOrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner seedOrders(CustomerOrderRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new CustomerOrder(null, 1L, "Laptop", 65000));
                repository.save(new CustomerOrder(null, 2L, "Keyboard", 2500));
            }
        };
    }
}
