package cu.edu.cujae.backend.service;

import cu.edu.cujae.backend.core.dto.CourseDto;
import cu.edu.cujae.backend.core.dto.StudentDto;
import cu.edu.cujae.backend.core.service.StudentService;
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
public class StudentServiceImpl implements StudentService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void createStudent(StudentDto student) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call student_insert(?, ?, ?, ?, ?, ?, ?, ?)}");
        CS.setInt(1, student.getStudent_ci());
        CS.setString(2,student.getStudent_name());
        CS.setString(3,student.getFirst_surname());
        CS.setString(4,student.getSecond_surname());
        CS.setString(5,student.getSex());
        CS.setInt(6, student.getId_town());
        CS.setInt(7, student.getId_student());
        CS.setInt(8, student.getId_student_history());

        CS.executeUpdate();
    }

    @Override
    public void updateStudent(StudentDto student) {

    }

    @Override
    public List<StudentDto> listStudent() throws SQLException {
        List<StudentDto> studentList = new ArrayList<StudentDto>();
        ResultSet rs = jdbcTemplate.getDataSource().getConnection().createStatement().executeQuery(
                "SELECT * FROM student");

        while(rs.next()){
            studentList.add(new StudentDto(rs.getInt("student_ci")
                    ,rs.getString("student_name")
                    ,rs.getString("first_surname")
                    ,rs.getString("second_surname")
                    ,rs.getString("sex")
                    ,rs.getInt("id_town")
                    ,rs.getInt("id_student")
                    ,rs.getInt("id_student_history")));
        }
        return studentList;
    }

    @Override
    public StudentDto getStudentById(Integer id) throws SQLException {
        StudentDto student = null;

        PreparedStatement pstmt = jdbcTemplate.getDataSource().getConnection().prepareStatement(
                "SELECT * FROM student where id_student = ?");

        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            student = new StudentDto(rs.getInt("student_ci")
                    ,rs.getString("student_name")
                    ,rs.getString("first_surname")
                    ,rs.getString("second_surname")
                    ,rs.getString("sex")
                    ,rs.getInt("id_town")
                    ,rs.getInt("id_student")
                    ,rs.getInt("id_student_history"));
        }
        return student;
    }

    @Override
    public void deleteStudent(Integer id) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall(
                "{call student_delete(?)}");

        CS.setInt(1, id);
        CS.executeUpdate();
    }
}
