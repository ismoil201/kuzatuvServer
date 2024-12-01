package com.example.kuzatuv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmsDto {
    private  Long id;
    private String sender;
    private String message;
}
