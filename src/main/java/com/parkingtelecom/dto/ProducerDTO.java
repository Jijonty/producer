package com.parkingtelecom.dto;

public class ProducerDTO {
    private String exchange;
    private String routingKey;
    private Long messages;
    private String payload;

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public Long getMessages() {
        return messages;
    }

    public void setMessages(Long messages) {
        this.messages = messages;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
