package com.prueba.calendar.app.controller;

import com.prueba.calendar.domain.model.Instructor;
import com.prueba.calendar.domain.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value ="/instructor")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class InstructorController {

    private InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService){
        this.instructorService = instructorService;
    }

    @GetMapping(value ="{id}")
    Instructor findInstructor(@PathVariable Integer id){
        return instructorService.getInstructor(id);
    }

    @PostMapping(value = "/")
    Integer createInstructor(@Valid @RequestBody Instructor instructor){
        return instructorService.createInstructor(instructor);
    }

    @GetMapping(value ="/")
    Iterable<Instructor> findAllInstructors(){
        return instructorService.getAllInstructors();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
