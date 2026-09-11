package com.mathsolver.api.domain.exercise.dto;

import jakarta.validation.constraints.NotBlank;

public record SolveProblemRequest(
    @NotBlank(message = "O código LaTeX é obrigatório para renderização e prompt")
    String inputLatex,

    @NotBlank(message = "A expressão matemática computável é obrigatória para o Symja")
    String mathExpression,

    String operation
) {}