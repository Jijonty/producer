package com.parkingtelecom.controller;

import com.parkingtelecom.entity.ProducerEntity;
import com.parkingtelecom.entity.SuccessMessage;
import com.parkingtelecom.errors.ErrorResponse;
import com.parkingtelecom.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.OffsetDateTime;


@Controller
public class ProducersController {

    @Autowired
    private ProducerService producerService;

    @PostMapping("/rabbit/producers")
    @ResponseBody
    public ResponseEntity<?> produceMessage(@RequestBody ProducerEntity producer) {
        producerService.sendMessage(producer);
        return ResponseEntity.ok(new SuccessMessage());

    }

}
