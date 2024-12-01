package com.example.kuzatuv.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {
    private Long id;
    private Double latitude;
    private Double longitude;
}
