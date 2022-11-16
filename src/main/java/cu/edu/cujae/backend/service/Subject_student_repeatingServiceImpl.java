package cu.edu.cujae.backend.service;

import cu.edu.cujae.backend.core.dto.CourseDto;
import cu.edu.cujae.backend.core.dto.Subject_student_repeatingDto;
import cu.edu.cujae.backend.core.service.Subject_student_repeatingService;
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
public class Subject_student_repeatingServiceImpl implements Subject_student_repeatingService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void createSubject_student_repeating(Subject_student_repeatingDto objects) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call subject_student_repeating_insert(?, ?)}");
        CS.setInt(1,objects.getId_subject());
        CS.setInt(2,objects.getId_student_repeating());

        CS.executeUpdate();
    }

    @Override
    public void updateSubject_student_repeating(Subject_student_repeatingDto objects) {

    }

    @Override
    public List<Subject_student_repeatingDto> listSubject_student_repeating() throws SQLException {
        List<Subject_student_repeatingDto> subject_student_repeatingList = new ArrayList<Subject_student_repeatingDto>();
        ResultSet rs = jdbcTemplate.getDataSource().getConnection().createStatement().executeQuery(
                "SELECT * FROM subject_student_repeating");

        while(rs.next()){
            subject_student_repeatingList.add(new Subject_student_repeatingDto(rs.getInt("id_subject")
                    ,rs.getInt("id_student_repeating")));
        }
        return subject_student_repeatingList;
    }

    @Override
    public Subject_student_repeatingDto getSubject_student_repeatingById(Integer id) throws SQLException {
        Subject_student_repeatingDto subject_student_repeating = null;

        PreparedStatement pstmt = jdbcTemplate.getDataSource().getConnection().prepareStatement(
                "SELECT * FROM subject_student_repeating where id_subject_student_repeating = ?");

        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            subject_student_repeating = new Subject_student_repeatingDto(rs.getInt("id_subject")
                    ,rs.getInt("id_student_repeating"));
        }
        return subject_student_repeating;
    }

    @Override
    public void deleteSubject_student_repeating(Integer id) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall(
                "{call subject_student_repeating_delete(?)}");

        CS.setInt(1, id);
        CS.executeUpdate();
    }
}
