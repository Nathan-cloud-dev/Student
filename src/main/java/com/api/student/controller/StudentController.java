package com.api.student.controller;


import com.api.student.models.Student;
import com.api.student.services.StudentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping ("api/Students")



public class StudentController {
    @Autowired
    private final StudentService service;

    private StudentController (StudentService service){
        this.service = service;
    }

    @PostMapping
    @RequestMapping("/student")
    public Mono <Student> save (@Valid @RequestBody Student student) {
        return service.save(student)
                .doOnNext(saved -> log.info("Student admitted with id: {} ", saved.getId()))
                .doOnError(throwable ->log.error("Failed to save Student", throwable));
    }

    @GetMapping
    @RequestMapping ("/getStudent/{id}")
    public Mono<Student>findById (@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping
    @RequestMapping ("/students")
    public Flux<Student> findAll (){
        return service.findAll ();
    }

    @PutMapping
    public Mono<Student>updateById (@PathVariable Long id, @RequestBody Student student){
        return service.updateById(id,student);
    }

}
