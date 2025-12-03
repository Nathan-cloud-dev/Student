package com.api.student.services;

import com.api.student.models.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {


    Mono<Student> save(Student student);

    Mono<Student> findById(Long id);

    Flux<Student> findAll();

    Mono<Student> updateById(Long id, Student student);
}
