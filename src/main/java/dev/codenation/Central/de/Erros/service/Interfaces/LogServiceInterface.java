package dev.codenation.Central.de.Erros.service.Interfaces;

import dev.codenation.Central.de.Erros.model.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface LogServiceInterface {

    Log create(Log log);

    Page<Log> getAll(Pageable pageable);

    Optional<Log> getById(Long id);

    Page<Log> getByFilter(String filter, String value, Pageable pageable);
}
