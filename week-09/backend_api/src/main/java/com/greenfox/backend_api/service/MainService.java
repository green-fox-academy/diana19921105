package com.greenfox.backend_api.service;

import com.greenfox.backend_api.model.Log;
import com.greenfox.backend_api.model.LogResponseDto;
import com.greenfox.backend_api.model.LogResult;
import com.greenfox.backend_api.repository.RestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MainService {

    private RestRepository restRepository;

    @Autowired
    public MainService(RestRepository restRepository) {
        this.restRepository = restRepository;
    }

    public void save(Log log) {
        restRepository.save(log);
    }

    public LogResult getLogs() {
        List<LogResponseDto> entries = ((List<Log>) restRepository.findAll())
                .stream()
                .map(e -> new LogResponseDto(e.getId(), e.getEndPoint(), e.getData()))
                .collect(Collectors.toList());
        int size = entries.size();
        return new LogResult(size, entries);
    }
}
