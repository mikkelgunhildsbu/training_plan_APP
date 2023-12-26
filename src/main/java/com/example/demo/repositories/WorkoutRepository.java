package com.example.demo.repositories;

import com.example.demo.domain.Workout;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Annotation
@Repository
public interface WorkoutRepository extends CrudRepository<Workout, Long> {


}

