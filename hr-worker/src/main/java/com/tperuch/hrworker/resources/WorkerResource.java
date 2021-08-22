package com.tperuch.hrworker.resources;

import com.tperuch.hrworker.entities.Worker;
import com.tperuch.hrworker.service.WorkerService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
@AllArgsConstructor
public class WorkerResource {

    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
    private Environment environment;
    private WorkerService service;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        logger.info("PORT = {}", environment.getProperty("local.server.port"));
                Worker entity = service.findById(id);
        return ResponseEntity.ok(entity);
    }
}
