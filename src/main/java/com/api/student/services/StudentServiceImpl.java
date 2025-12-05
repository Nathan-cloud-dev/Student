package com.api.student.services;

import com.api.student.models.Student;
import com.api.student.repository.StudentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service

public class StudentServiceImpl implements StudentService{
    public final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }


    @Override
    public Mono<Student> save(Student student) {
        return repository.save(student);
    }


    @Override
    public Mono<Student> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Flux<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Student> updateById(Long id, Student student) {
        return repository.updateById(id,student);
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return repository.deleteById(id);
    }
}
