package com.mariowesley.hr_worker.resources;

import com.mariowesley.hr_worker.entities.Worker;
import com.mariowesley.hr_worker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Worker> findById(@PathVariable long id){
        Worker worker = repository.findById(id).orElse(null);
        return ResponseEntity.ok(worker);
    }

}
