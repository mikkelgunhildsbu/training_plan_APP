package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long workoutID;
    private String workOutName;
    private Double distance;
    private Date workoutDate;
    private Role role;
    private Boolean completed;

    private String workOutDescription;

    @ManyToOne
    private Customer user;


}
