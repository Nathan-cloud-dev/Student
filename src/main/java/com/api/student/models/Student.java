package com.api.student.models;


import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;


@Table (name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode (of = "id")
public class Student {

    @Id
    private Long id;
    @NotBlank (message = "Name is required.")
    private String firstName;
    private String lastName;


    @NotBlank (message = "Email should not be empty")
    @Email
    private String email;
    private String course;
    private Boolean isActive;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
