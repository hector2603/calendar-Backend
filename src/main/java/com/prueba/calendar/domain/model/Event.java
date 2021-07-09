package com.prueba.calendar.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "the startDate field must not be empty")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;

    @NotNull(message = "the endDate field must not be empty")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    @NotEmpty(message = "the description field must not be empty")
    private String description;

    @NotEmpty(message = "the eventType field must not be empty")
    private String eventType;

    @NotNull
    @ManyToOne
    @JoinColumn(name="instructor_id", nullable=false)
    @JsonIgnoreProperties(value="event")
    private Instructor instructor;
}
