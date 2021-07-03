package com.prueba.calendar.domain.service;

import com.prueba.calendar.domain.model.Event;
import com.prueba.calendar.domain.model.Instructor;
import com.prueba.calendar.domain.repository.EventRepository;
import com.prueba.calendar.domain.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class InstructorService {

    private final InstructorRepository instructorRepository;
    private final EventRepository eventRepository;

    public InstructorService(InstructorRepository instructorRepository,EventRepository eventRepository){
        this.instructorRepository = instructorRepository;
        this.eventRepository = eventRepository;
    }

    public Integer createInstructor(Instructor instructor){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date today = c.getTime();
        c.add(Calendar.DATE, 7);
        Date endwewk1 = c.getTime();
        c.add(Calendar.DATE, 1);
        Date startweek2 = c.getTime();
        c.add(Calendar.DATE, 7);
        Date endwewk2 = c.getTime();
        c.add(Calendar.DATE, 1);
        Date startweek3 = c.getTime();
        c.add(Calendar.DATE, 7);
        Date endwewk3 = c.getTime();
        c.add(Calendar.DATE, 1);
        Date startweek4 = c.getTime();
        c.add(Calendar.DATE, 7);
        Date endwewk4 = c.getTime();

        Instructor responseInstructor = instructorRepository.save(instructor);

        Event evento1 = new Event();
        evento1.setInstructor(responseInstructor);
        evento1.setStartDate(today);
        evento1.setEndDate(endwewk1);
        evento1.setDescription("Seminars");

        eventRepository.save(evento1);

        Event evento2 = new Event();
        evento2.setInstructor(responseInstructor);
        evento2.setStartDate(startweek2);
        evento2.setEndDate(endwewk2);
        evento2.setDescription("Project");

        eventRepository.save(evento2);

        Event evento3 = new Event();
        evento3.setInstructor(responseInstructor);
        evento3.setStartDate(startweek3);
        evento3.setEndDate(endwewk3);
        evento3.setDescription("Week Off");

        eventRepository.save(evento3);

        Event evento4 = new Event();
        evento4.setInstructor(responseInstructor);
        evento4.setStartDate(startweek4);
        evento4.setEndDate(endwewk4);
        evento4.setDescription("Seminars");

        eventRepository.save(evento4);

        return responseInstructor.getId();
    }

    public Instructor getInstructor(Integer id){
        Optional<Instructor> responseInstructor =  instructorRepository.findById(id);
        return responseInstructor.get();

    }

    public Iterable<Instructor> getAllInstructors() {
        Iterable<Instructor> responseInstructors =  instructorRepository.findAll();
        for(Instructor i : responseInstructors){
            Long days = 0L;
            for (Event event: i.getEvents()) {
                days += Duration.between(event.getStartDate().toInstant() , event.getEndDate().toInstant()).toDays();
            }
            i.setDuration(days);
        }
        return responseInstructors;
    }
}
