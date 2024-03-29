package com.tperuch.hrworker.resources;

import com.tperuch.hrworker.entities.WorkerEntity;
import com.tperuch.hrworker.repository.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/workers")
public class WorkerResource {


    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    @Value("${test.config}")
    private String testConfig;

    @Autowired
    private Environment environment;

    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<WorkerEntity>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<WorkerEntity> findById(@PathVariable Long id){
        logger.info("port = {}", environment.getProperty("local.server.port"));
        return ResponseEntity.ok(repository.findById(id).get());
    }

    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs(){
        logger.info("config = {}", testConfig);
        return ResponseEntity.noContent().build();
    }
}
