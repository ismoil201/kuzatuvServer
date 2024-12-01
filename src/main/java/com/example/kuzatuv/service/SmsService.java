package com.example.kuzatuv.service;

import com.example.kuzatuv.dto.LocationDto;
import com.example.kuzatuv.dto.SmsDto;
import com.example.kuzatuv.model.Sms;
import com.example.kuzatuv.repository.SmsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SmsService {
    private final SmsRepository smsRepository;

    public Sms saveSms(SmsDto smsDto) {
        Sms sms = new Sms(smsDto.getId(), smsDto.getSender(), smsDto.getMessage(), LocalDateTime.now());
        smsRepository.save(sms);
        return sms;
    }

    public List<SmsDto> getMessage() {
        var messagess = smsRepository.findAll();
        return messagess.stream().map(messages ->
                        new SmsDto(messages.getId(),messages.getSender(), messages.getMessage()))
                .collect(Collectors.toList());
    }
}

