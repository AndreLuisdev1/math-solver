package com.mathsolver.api.domain.service;

import com.mathsolver.api.domain.exercise.Exercise;
import com.mathsolver.api.domain.repository.ExerciseRepository;
import com.mathsolver.api.domain.exercise.dto.SolveProblemRequest;
import com.mathsolver.api.domain.exercise.dto.ExerciseResponse;
// import com.mathsolver.api.domain.exercise.dto.StepDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExerciseService {

    private final AsciiMathToSymjaConverter converter;
    private final SymjaMathService symjaMathService;


    public ExerciseResponse solveAndExplain(SolveProblemRequest request) {
        String symjaExpression = converter.convert(request.mathExpression());
        String result = symjaMathService.calculate(symjaExpression, "EVALUATE");

        Exercise exercise = new Exercise();
        exercise.setInputLatex(request.inputLatex());


        return new ExerciseResponse(
            exercise.getId(), request.inputLatex(), result, exercise.getCreatedAt()
        );
    }
}