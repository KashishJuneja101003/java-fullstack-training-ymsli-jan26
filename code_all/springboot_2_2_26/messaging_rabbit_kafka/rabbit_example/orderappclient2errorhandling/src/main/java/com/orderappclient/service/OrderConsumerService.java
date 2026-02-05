package com.orderappclient.service;

import com.orderappclient.config.RabbitMQConfig;
import com.orderappclient.dto.OrderResponse;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

//-----------Consumer side-------------------------
@Service
public class OrderConsumerService {

    @RabbitListener(queues = RabbitMQConfig.ORDER_QUEUE)
    public void consumeOrderResponse(OrderResponse orderResponse){
    	if (orderResponse.getOrder().getOrderId() == null) {
            throw new RuntimeException("Invalid order");
        }
        System.out.println("Processed: " + orderResponse);
    }
}
