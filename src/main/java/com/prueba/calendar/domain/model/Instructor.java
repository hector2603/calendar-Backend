package com.prueba.calendar.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Instructor {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "the name field must not be empty")
    private String name;
    @NotBlank(message = "the lastName field must not be empty")
    private String lastName;

    @NotNull(message = "the birthDate field must not be empty")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthDate;

    @OneToMany(mappedBy="instructor")
    @JsonIgnoreProperties(value="instructor")
    private Set<Event> events;

    private Long duration;


}
