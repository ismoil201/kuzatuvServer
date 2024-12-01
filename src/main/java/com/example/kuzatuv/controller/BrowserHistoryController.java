package com.example.kuzatuv.controller;

import com.example.kuzatuv.dto.BrowserHistoryDto;
import com.example.kuzatuv.model.BrowserHistory;
import com.example.kuzatuv.service.BrowserHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/browser")
@RequiredArgsConstructor
public class BrowserHistoryController {
    private final BrowserHistoryService historyService;

    @PostMapping("/save")
    public ResponseEntity<BrowserHistory> saveHistory(@RequestBody BrowserHistoryDto historyDto) {
        var history = historyService.saveHistory(historyDto);
        return ResponseEntity.ok(history);
    }

    @GetMapping("/histories")
    public ResponseEntity<List<BrowserHistoryDto>> getHistory() {
        var histories = historyService.getHistories();

        return ResponseEntity.ok(histories);
    }
}
