package com.mathsolver.api.domain.exercise.dto;

import java.util.List;

public record AiResolutionResponse(
    String topic,
    String finalAnswer
    // List<StepDetail> steps
) {}