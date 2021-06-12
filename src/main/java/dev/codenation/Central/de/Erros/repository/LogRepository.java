package dev.codenation.Central.de.Erros.repository;

import dev.codenation.Central.de.Erros.model.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

    Page<Log> findByLevel(String value, Pageable pageable);
    Page<Log> findByDescription(String value, Pageable pageable);
    Page<Log> findByOrigin(String value, Pageable pageable);
    Page<Log> findByDate(LocalDateTime value, Pageable pageable);
    Page<Log> findByQuantity(Long value, Pageable pageable);

}