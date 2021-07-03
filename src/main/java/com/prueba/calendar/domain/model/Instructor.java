package com.prueba.calendar.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Instructor {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "lastName is mandatory")
    private String lastName;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthDate;
    @OneToMany(mappedBy="instructor")
    @JsonIgnoreProperties(value="instructor")
    private Set<Event> events;

    private Long duration;


}
