package cu.edu.cujae.backend.service;

import cu.edu.cujae.backend.core.dto.CourseDto;
import cu.edu.cujae.backend.core.dto.Student_repeatingDto;
import cu.edu.cujae.backend.core.service.Student_repeatingService;
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
public class Student_repeatingServiceImpl implements Student_repeatingService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void createStudent_repeating(Student_repeatingDto student_repeating) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call student_repeating_insert(?, ?, ?)}");
        CS.setInt(1,student_repeating.getId_student_repeating());
        CS.setInt(2,student_repeating.getId_subject());
        CS.setInt(3,student_repeating.getId_student());

        CS.executeUpdate();
    }

    @Override
    public void updateStudent_repeating(Student_repeatingDto student_repeating) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call student_repeating_insert(?, ?, ?)}");
        CS.setInt(1,student_repeating.getId_student_repeating());
        CS.setInt(2,student_repeating.getId_subject());
        CS.setInt(3,student_repeating.getId_student());
        CS.execute();
        CS.close();
    }

    @Override
    public List<Student_repeatingDto> listStudent_repeatingDto() throws SQLException {
        List<Student_repeatingDto> student_repeatingList = new ArrayList<Student_repeatingDto>();
        ResultSet rs = jdbcTemplate.getDataSource().getConnection().createStatement().executeQuery(
                "SELECT * FROM student_repeating");

        while(rs.next()){
            student_repeatingList.add(new Student_repeatingDto(rs.getInt("id_student_repeating")
                    ,rs.getInt("id_subject")
                    ,rs.getInt("id_student")));
        }
        return student_repeatingList;
    }

    @Override
    public Student_repeatingDto getStudent_repeatingById(Integer id) throws SQLException {
        Student_repeatingDto student_repeating = null;

        PreparedStatement pstmt = jdbcTemplate.getDataSource().getConnection().prepareStatement(
                "SELECT * FROM student_repeating where id_student_repeating = ?");

        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            student_repeating = new Student_repeatingDto(rs.getInt("id_student_repeating")
                    ,rs.getInt("id_subject")
                    ,rs.getInt("id_student"));
        }
        return student_repeating;
    }

    @Override
    public void deleteStudent_repeating(Integer id) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall(
                "{call student_repeating_delete(?)}");

        CS.setInt(1, id);
        CS.executeUpdate();
    }
}
