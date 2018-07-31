package com.parkingtelecom.controller;

import com.parkingtelecom.dto.ProducerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ProducersController {

    @PostMapping("/rabbit/producers")
    @ResponseBody
    public ResponseEntity<?> produceMessage(@RequestBody ProducerDTO dto) {
        return null;
    }

}
