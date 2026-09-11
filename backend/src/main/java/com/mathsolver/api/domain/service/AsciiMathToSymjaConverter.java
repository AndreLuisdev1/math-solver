package com.mathsolver.api.domain.service;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AsciiMathToSymjaConverter {

    private static final Map<String, String> TOKEN_REPLACEMENTS = Map.of(
        "oo", "Infinity"
    );

    public String convert(String asciiMath) {
        if (asciiMath == null || asciiMath.isBlank()) {
            throw new IllegalArgumentException("Expressão não pode ser vazia.");
        }

        String result = asciiMath.trim();
        for (var entry : TOKEN_REPLACEMENTS.entrySet()) {
            result = result.replace(entry.getKey(), entry.getValue());
        }
        return result;
    }
}