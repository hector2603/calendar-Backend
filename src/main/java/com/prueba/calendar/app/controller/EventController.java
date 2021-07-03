package com.prueba.calendar.app.controller;

import com.prueba.calendar.domain.model.Event;
import com.prueba.calendar.domain.model.Instructor;
import com.prueba.calendar.domain.service.EventService;
import com.prueba.calendar.domain.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value ="/event")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class EventController {
    private EventService eventService;

    @Autowired
    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping(value ="{id}")
    Event findEvent(@PathVariable Integer id){
        return eventService.getEvent(id);
    }

    @PostMapping(value = "/")
    Integer createEvent(@Valid @RequestBody Event event){
        return eventService.createEvent(event);
    }

    @PostMapping(value = "/update")
    Integer updateEvent(@Valid @RequestBody Event event){
        return eventService.updateEvent(event);
    }

    @GetMapping(value ="/")
    Iterable<Event> findAllEvents(){
        return eventService.getAllEvents();
    }

    @DeleteMapping(value ="/{id}")
    Integer DeleteEvent(@Valid @PathVariable Integer id){
        return eventService.deleteEvent(id);
    }
}
