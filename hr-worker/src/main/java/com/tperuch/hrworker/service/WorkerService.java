package com.tperuch.hrworker.service;

import com.tperuch.hrworker.entities.Worker;
import com.tperuch.hrworker.repository.WorkerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkerService {

    private WorkerRepository repository;

    public List<Worker> findAll(){
        return repository.findAll();
    }

    public Worker findById(Long id){
        return repository.findById(id).get();
    }
}
