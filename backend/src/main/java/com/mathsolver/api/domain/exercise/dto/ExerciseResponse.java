package com.mathsolver.api.domain.exercise.dto;

import java.time.Instant;
import java.util.UUID;

public record ExerciseResponse(
    UUID id,
    String inputAsciiMath,
    String result,
    Instant createdAt
) {}