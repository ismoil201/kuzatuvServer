package com.example.kuzatuv.service;


import com.example.kuzatuv.dto.LocationDto;
import com.example.kuzatuv.model.Location;
import com.example.kuzatuv.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    public void saveLocation(LocationDto locationDto) {
        Location location = new Location(locationDto.getId(), locationDto.getLatitude(), locationDto.getLongitude(), LocalDateTime.now());
        locationRepository.save(location);
    }


    public List<LocationDto> getLocations() {
        var locations = locationRepository.findAll();
        return locations.stream().map(location ->
                new LocationDto(location.getId(),location.getLatitude(), location.getLongitude()))
                .collect(Collectors.toList());
    }
}