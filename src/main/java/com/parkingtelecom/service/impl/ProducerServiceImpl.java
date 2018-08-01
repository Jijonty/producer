package com.parkingtelecom.service.impl;

import com.parkingtelecom.entity.ProducerEntity;
import com.parkingtelecom.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProducerServiceImpl implements ProducerService {

    private static final Logger log = LoggerFactory.getLogger(ProducerServiceImpl.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(ProducerEntity producer) throws AmqpException {
        log.info("Sending message "+producer.getPayload());
        rabbitTemplate.convertAndSend(producer.getExchange(), producer.getRoutingKey(), producer.getPayload());
    }
}
