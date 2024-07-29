package com.mariowesley.hr_worker.resources;

import com.mariowesley.hr_worker.entities.Worker;
import com.mariowesley.hr_worker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResources {

    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> workers = repository.findAll();
        return ResponseEntity.ok(workers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findByID(@PathVariable Long id) {
        Worker worker = repository.findById(id).orElse(null);
        assert worker != null;
        return ResponseEntity.ok(worker);
    }
}
