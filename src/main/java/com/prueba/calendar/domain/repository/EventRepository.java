package com.prueba.calendar.domain.repository;

import com.prueba.calendar.domain.model.Event;
import com.prueba.calendar.domain.model.Instructor;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer> {
}
