package com.example.demo.service;

import com.example.demo.domain.Workout;
import org.springframework.stereotype.Service;

@Service
public interface WorkoutService {

    Workout saveWorkout (Workout workout);


    Workout getWorkoutByID(Long workoutId);

    Workout updateWorkout(Workout workout, Long workoutId);


    void deleteWorkoutById(Long workoutId);


    Boolean isOwner(Long customerId, Long workoutId);
}
