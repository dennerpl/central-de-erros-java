package dev.codenation.Central.de.Erros.model;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name="logs")
public class Log {

    public Log(Long id, @NotNull String level, @NotNull String description, @NotNull String log, @NotNull String origin, @NotNull LocalDateTime date, @NotNull Long quantity) {
        this.id = id;
        this.level = level;
        this.description = description;
        this.log = log;
        this.origin = origin;
        this.date = date;
        this.quantity = quantity;
    }

    public Log() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @Column
    String level;

    @NotNull
    @Column
    String description;

    @NotNull
    @Column
    String log;

    @NotNull
    @Column
    String origin;

    @NotNull
    @Column
    LocalDateTime date;

    @NotNull
    @Column
    Long quantity;

    public void setId(Long id) {
        this.id = id;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

}
