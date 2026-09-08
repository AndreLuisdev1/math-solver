package com.mathsolver.api.domain.exercise;

public record StepDetail(
    int stepOrder,
    String explanation,
    String stepLatex
) {}