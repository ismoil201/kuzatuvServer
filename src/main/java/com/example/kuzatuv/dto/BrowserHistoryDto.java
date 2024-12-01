package com.example.kuzatuv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrowserHistoryDto {
    private  Long id;
    private String url;
    private String title;
}
