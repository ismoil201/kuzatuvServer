package com.example.kuzatuv.controller;

import com.example.kuzatuv.dto.BrowserHistoryDto;
import com.example.kuzatuv.dto.LocationDto;
import com.example.kuzatuv.model.Location;
import com.example.kuzatuv.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @PostMapping("/save")
    public ResponseEntity<String> saveLocation(@RequestBody LocationDto locationDto) {
        locationService.saveLocation(locationDto);
        return ResponseEntity.ok("Location saved successfully!");
    }

    @GetMapping("/locations")
    public ResponseEntity<List<LocationDto>> getHistory() {
        var locations = locationService.getLocations();

        return ResponseEntity.ok(locations);
    }
}