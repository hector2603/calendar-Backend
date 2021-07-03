package com.prueba.calendar.infrastructure;

import com.prueba.calendar.domain.repository.EventRepository;
import com.prueba.calendar.domain.repository.InstructorRepository;
import com.prueba.calendar.domain.service.EventService;
import com.prueba.calendar.domain.service.InstructorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    InstructorService instructorService(InstructorRepository instructorRepository, EventRepository eventRepository){
        return new InstructorService(instructorRepository,eventRepository);
    }

    @Bean
    EventService eventService(EventRepository eventRepository){
        return new EventService(eventRepository);
    }

}
