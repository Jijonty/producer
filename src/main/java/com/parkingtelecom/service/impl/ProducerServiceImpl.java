package com.parkingtelecom.service.impl;

import com.parkingtelecom.entity.ProducerEntity;
import com.parkingtelecom.service.ProducerService;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.ChannelCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Service;


@Service
public class ProducerServiceImpl implements ProducerService {

    private static final Logger log = LoggerFactory.getLogger(ProducerServiceImpl.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(ProducerEntity producer) {
        rabbitTemplate.execute(new ChannelCallback<AMQP.Exchange.DeclareOk>() {
            @Override
            public AMQP.Exchange.DeclareOk doInRabbit(Channel channel) throws Exception {
                try {
                    return channel.exchangeDeclarePassive(producer.getExchange());
                } catch (Exception e) {
                    log.error(e.getMessage());
                    throw new AmqpException("Ooops, something goes wrong!");
                    //return null;
                }
            }
        });

        for(int i=0;i<producer.getMessages();i++) {
            log.info("Sending message " + producer.getPayload());
            rabbitTemplate.convertAndSend(producer.getExchange(), producer.getRoutingKey(), producer.getPayload());
        }
    }
}
