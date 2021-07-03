package com.prueba.calendar.domain.repository;

import com.prueba.calendar.domain.model.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface  InstructorRepository extends CrudRepository<Instructor, Integer> {
}
