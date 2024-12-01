package com.example.kuzatuv.controller;

import com.example.kuzatuv.dto.LocationDto;
import com.example.kuzatuv.dto.SmsDto;
import com.example.kuzatuv.model.Sms;
import com.example.kuzatuv.service.SmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sms")
@RequiredArgsConstructor
public class SmsController {
    private final SmsService smsService;

    @PostMapping("/save")
    public ResponseEntity<Sms> saveSms(@RequestBody SmsDto smsDto) {
       var sms =  smsService.saveSms(smsDto);
       return ResponseEntity.ok(sms);
    }

    @GetMapping("/message")
    public ResponseEntity<List<SmsDto>> getMessage() {
        var message = smsService.getMessage();

        return ResponseEntity.ok(message);
    }
}