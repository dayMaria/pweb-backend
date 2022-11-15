package cu.edu.cujae.backend.service;

import cu.edu.cujae.backend.core.dto.CourseDto;
import cu.edu.cujae.backend.core.dto.EvaluationDto;
import cu.edu.cujae.backend.core.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void createEvaluation(EvaluationDto evaluation) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call evaluation_insert(?, ?, ?, ?)}");
        CS.setInt(1,evaluation.getEvaluation());
        CS.setInt(2, evaluation.getId_subject());
        CS.setInt(3, evaluation.getId_student_history());
        CS.setDate(4,evaluation.getDate());

        CS.executeUpdate();
    }

    @Override
    public void updateEvaluation(EvaluationDto evaluation) {

    }

    @Override
    public List<EvaluationDto> listEvaluation() throws SQLException {
        List<EvaluationDto> evaluationList = new ArrayList<EvaluationDto>();
        ResultSet rs = jdbcTemplate.getDataSource().getConnection().createStatement().executeQuery(
                "SELECT * FROM evaluation");

        while(rs.next()){
            evaluationList.add(new EvaluationDto(rs.getInt("id_evaluation")
                    ,rs.getInt("evaluation")
                    ,rs.getInt("id_subject")
                    ,rs.getInt("id_student_history")
                    ,rs.getDate("date")));
        }
        return evaluationList;
    }

    @Override
    public EvaluationDto getEvaluationById(Integer Id) throws SQLException {
        EvaluationDto evaluation = null;

        PreparedStatement pstmt = jdbcTemplate.getDataSource().getConnection().prepareStatement(
                "SELECT * FROM evaluation where id_evaluation = ?");

        pstmt.setInt(1, Id);

        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            evaluation = new EvaluationDto(rs.getInt("id_evaluation")
                    ,rs.getInt("evaluation")
                    ,rs.getInt("id_subject")
                    ,rs.getInt("id_student_history")
                    ,rs.getDate("date"));
        }
        return evaluation;
    }

    @Override
    public void deleteEvaluation(Integer id) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall(
                "{call evaluation_delete(?)}");

        CS.setInt(1, id);
        CS.executeUpdate();
    }
}
