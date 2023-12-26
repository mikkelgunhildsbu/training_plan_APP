package com.example.demo.controllers;

import com.example.demo.domain.Workout;
import com.example.demo.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class WorkoutController {
    // Annotation
    @Autowired
    private WorkoutService workoutService;

    // Save operation
    @PostMapping("/workouts")
    public Workout saveWorkout(@RequestBody Workout workout)
    {
        return workoutService.saveWorkout(workout);
    }

    // Get workout
    @GetMapping("workout/{id}")

    public Workout getWorkoutByID(@PathVariable("id") Long workoutId) {
        return workoutService.getWorkoutByID(workoutId);
    }




    // Update operation
    @PutMapping("/workout/{id}")

    public Workout
    updateWorkout(@RequestBody Workout workout,
                   @PathVariable("id") Long workoutId)
    {
        return workoutService.updateWorkout(
                workout, workoutId);
    }

    // Delete operation
    @DeleteMapping("/workout/{id}")

    public String deleteCalenderById(@PathVariable("id")
                                     Long workoutId)
    {

        workoutService.deleteWorkoutById(
                workoutId);
        return "Deleted Successfully";
    }


}
