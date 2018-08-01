package com.parkingtelecom.service.impl;

import com.parkingtelecom.entity.ProducerEntity;
import com.parkingtelecom.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


@Service
public class ProducerServiceImpl implements ProducerService {

    private static final Logger log = LoggerFactory.getLogger(ProducerServiceImpl.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(ProducerEntity producer) {
        log.info("Sending message "+producer.getPayload());
        rabbitTemplate.convertAndSend(producer.getExchange(), producer.getRoutingKey(), producer.getPayload());
    }
}
