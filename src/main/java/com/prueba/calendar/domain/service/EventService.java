package com.prueba.calendar.domain.service;

import com.prueba.calendar.domain.model.Event;
import com.prueba.calendar.domain.model.Instructor;
import com.prueba.calendar.domain.repository.EventRepository;
import com.prueba.calendar.domain.repository.InstructorRepository;

public class EventService {


    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }
    public Event getEvent(Integer id) {
        return eventRepository.findById(id).get();
    }

    public Integer createEvent(Event event) {
        return eventRepository.save(event).getId();
    }

    public Iterable<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Integer updateEvent(Event event) {
        eventRepository.delete(event);
        return eventRepository.save(event).getId();
    }

    public Integer deleteEvent(Integer idEvent) {
        Event event = new Event();
        event.setId(idEvent);
        eventRepository.delete(event);
        return event.getId();
    }
}
