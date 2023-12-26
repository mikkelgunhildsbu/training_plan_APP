package com.example.demo.service;

import com.example.demo.domain.Workout;
import com.example.demo.repositories.WorkoutRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service

public class WorkoutServiceImpl implements WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Override
    public Workout saveWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }


    @Override
    public Workout getWorkoutByID(Long workoutId) {
        return workoutRepository.findById(workoutId).orElseThrow(() -> new EntityNotFoundException("Workout not found with ID: " + workoutId));
    }

    @Override
    public Workout updateWorkout(Workout workout, Long workoutId) {
        Optional<Workout> workoutOptional = workoutRepository.findById(workoutId);

        if (workoutOptional.isPresent()) {
            Workout depDB = workoutOptional.get();

            if (Objects.nonNull(workout.getWorkOutName()) && !"".equalsIgnoreCase(workout.getWorkOutName())) {
                depDB.setWorkOutName(workout.getWorkOutName());
            }

            if (Objects.nonNull(workout.getRole())) {
                depDB.setRole(workout.getRole());
            }
            if (Objects.nonNull(workout.getWorkoutDate())){
                depDB.setWorkoutDate(workout.getWorkoutDate());
            }

            if (Objects.nonNull(workout.getWorkOutDescription())){
                depDB.setWorkOutDescription(workout.getWorkOutDescription());
            }

            if (Objects.nonNull(workout.getCompleted())){
                depDB.setCompleted(workout.getCompleted());
            }

            if (Objects.nonNull(workout.getDistance())) {
                depDB.setDistance(workout.getDistance());
            }




            return workoutRepository.save(depDB);
    } else {
        return null;
    }}

    public void deleteWorkoutById(Long workoutId) {
        workoutRepository.deleteById(workoutId);
    }

    @Override
    public Boolean isOwner(Long customerId, Long workoutId) {
        return workoutRepository.findById(workoutId)
                .map(workout -> workout.getUser().getCustomerId().equals(customerId))
                .orElse(false);
    }

}
