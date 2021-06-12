package dev.codenation.Central.de.Erros.service.Impl;

import dev.codenation.Central.de.Erros.model.Log;
import dev.codenation.Central.de.Erros.repository.LogRepository;
import dev.codenation.Central.de.Erros.service.Interfaces.LogServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LogServiceImpl implements LogServiceInterface {

    private final LogRepository logRepository;

    public LogServiceImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public Log create(Log log) {
        return logRepository.save(log);
    }

    @Override
    public Page<Log> getAll(Pageable pageable) {
        return logRepository.findAll(pageable);
    }

    @Override
    public Optional<Log> getById(Long id) {
        return logRepository.findById(id);
    }

    @Override
    public Page<Log> getByFilter(String filter, String value, Pageable pageable) {
        switch (filter) {
            case "level" :
                return logRepository.findByLevel(value, pageable);
            case "description" :
                return logRepository.findByDescription(value, pageable);
            case "origin" :
                return logRepository.findByOrigin(value, pageable);
            case "date" :
                return logRepository.findByDate(LocalDateTime.parse(value), pageable);
            case "quantity" :
                return logRepository.findByQuantity(Long.valueOf(value), pageable);
            default:
                return null;
        }
    }
}