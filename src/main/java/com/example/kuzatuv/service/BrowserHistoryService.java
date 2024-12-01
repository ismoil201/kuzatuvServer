package com.example.kuzatuv.service;

import com.example.kuzatuv.dto.BrowserHistoryDto;
import com.example.kuzatuv.model.BrowserHistory;
import com.example.kuzatuv.repository.BrowserHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrowserHistoryService {
    private final BrowserHistoryRepository historyRepository;

    public BrowserHistory saveHistory(BrowserHistoryDto historyDto) {
        BrowserHistory history = new BrowserHistory(historyDto.getId(), historyDto.getUrl(), historyDto.getTitle(), LocalDateTime.now());
        historyRepository.save(history);

        return history;
    }

    public List<BrowserHistoryDto> getHistories() {
        // Convert BrowserHistory to BrowserHistoryDto
        var histories = historyRepository.findAll();
        return histories.stream()
                .map(history -> new BrowserHistoryDto(history.getId(),history.getUrl(), history.getTitle()))
                .collect(Collectors.toList());
    }
}
