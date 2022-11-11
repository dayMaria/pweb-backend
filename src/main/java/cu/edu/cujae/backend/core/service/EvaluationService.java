package cu.edu.cujae.backend.core.service;

import cu.edu.cujae.backend.core.dto.EvaluationDto;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

public interface EvaluationService {
    void createEvaluation(EvaluationDto evaluation) throws SQLException;

    void updateEvaluation(EvaluationDto evaluation);

    List<EvaluationDto> listEvaluation() throws SQLException;

    EvaluationDto getEvaluationById(Integer Id) throws SQLException;

    void deleteEvaluation(Integer id) throws SQLException;
}
