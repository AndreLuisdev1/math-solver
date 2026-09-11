package com.mathsolver.api.controller;

import com.mathsolver.api.domain.exercise.dto.ExerciseResponse;
import com.mathsolver.api.domain.exercise.dto.SolveProblemRequest;
import com.mathsolver.api.domain.service.ExerciseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exercises")
@CrossOrigin(origins = "*")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping("/solve")
    public ResponseEntity<ExerciseResponse> solve(@RequestBody @Valid SolveProblemRequest request) {
        ExerciseResponse resolvedExercise = exerciseService.solveAndExplain(request);
        return ResponseEntity.ok(resolvedExercise);
    }
}