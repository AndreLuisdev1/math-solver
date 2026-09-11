package com.mathsolver.api.domain.service;

import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.interfaces.IExpr;
import org.springframework.stereotype.Service;

@Service
public class SymjaMathService {

    private static final int MAX_EXPRESSION_LENGTH = 200;

    private final ExprEvaluator evaluator = new ExprEvaluator(false, (short) 100);

    public synchronized String calculate(String expression, String operation) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException("Expressão não pode ser vazia.");
        }
        if (expression.length() > MAX_EXPRESSION_LENGTH) {
            throw new IllegalArgumentException("Expressão excede o tamanho máximo permitido.");
        }

        try {
            String command = switch (operation != null ? operation.toUpperCase() : "EVALUATE") {
                case "SOLVE" -> "Solve(" + expression + ", x)";
                case "DERIVATIVE" -> "D(" + expression + ", x)";
                default -> expression;
            };

            IExpr result = evaluator.eval(command);
            return result.toString();
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao processar cálculo no Symja: " + e.getMessage(), e);
        }
    }
}