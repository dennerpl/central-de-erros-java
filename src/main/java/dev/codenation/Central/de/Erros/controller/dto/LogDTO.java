package dev.codenation.Central.de.Erros.controller.dto;

import dev.codenation.Central.de.Erros.model.Log;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class LogDTO {

    Long id;
    String level;
    String description;
    String origin;
    LocalDateTime date;
    Long quantity;

    public LogDTO(Log log) {
        this.id = log.getId();
        this.level = log.getLevel();
        this.description = log.getDescription();
        this.origin = log.getOrigin();
        this.date = log.getDate();
        this.quantity = log.getQuantity();
    }
}
