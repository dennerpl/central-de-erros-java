package dev.codenation.Central.de.Erros.controller;

import dev.codenation.Central.de.Erros.controller.dto.LogDTO;
import dev.codenation.Central.de.Erros.model.Log;
import dev.codenation.Central.de.Erros.service.Impl.LogServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/logs")
@Api(value = "API to control the logs")
@CrossOrigin(origins = "*")
public class LogController {

    public LogController(LogServiceImpl logService) {
        this.logService = logService;
    }

    private final LogServiceImpl logService;

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Log created"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    @ApiOperation(value = "Create a new log")
    @PostMapping
    public Log create(@RequestBody Log log) {
        return logService.create(log);
    }


    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of logs returned"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    @ApiOperation(value = "Get all logs or filtered logs")
    @GetMapping
    public ResponseEntity<Page<LogDTO>> getAllAndgetByFilter(@PathParam("filter") String filter, @PathParam("value")String value, Pageable pageable) {
        if (filter == null) {
            Page<Log> listaLog = logService.getAll(pageable);
            return ResponseEntity.status(HttpStatus.OK).body(listaLog.map(log -> new LogDTO(log)));
        }  else {
            Page<Log> listaLog = logService.getByFilter(filter, value, pageable);
            if (listaLog == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }   else {
                return ResponseEntity.status(HttpStatus.OK).body(listaLog.map(log -> new LogDTO(log)));
            }
        }
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "One log returned"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    @ApiOperation(value = "Get a log by id")
    @GetMapping("/{id}")
    public ResponseEntity<Log> getById(@PathVariable Long id) {
        Optional<Log> log = logService.getById(id);
        return log.map(value -> ResponseEntity.status(HttpStatus.OK).body(value))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null));
    }
}