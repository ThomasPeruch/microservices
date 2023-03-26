package com.tperuch.hrworker.resources;

import com.tperuch.hrworker.entities.WorkerEntity;
import com.tperuch.hrworker.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerResource {

    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<WorkerEntity>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<WorkerEntity> findById(@PathVariable Long id){
        return ResponseEntity.ok(repository.findById(id).get());
    }
}
