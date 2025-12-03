package com.api.student.repository;

import com.api.student.models.Student;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;


@Repository
public interface StudentRepository extends R2dbcRepository <Student, Long> {

    Mono<Student> updateById(Long id, Student student);
}
