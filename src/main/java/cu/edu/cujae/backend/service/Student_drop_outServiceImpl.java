package cu.edu.cujae.backend.service;

import cu.edu.cujae.backend.core.dto.Student_drop_outDto;
import cu.edu.cujae.backend.core.service.Drop_out_causeService;
import cu.edu.cujae.backend.core.service.StudentService;
import cu.edu.cujae.backend.core.service.Student_drop_outService;
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
public class Student_drop_outServiceImpl implements Student_drop_outService {

    @Autowired
private StudentService studentService;
    @Autowired
    private Drop_out_causeService drop_out_causeService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void createStudent_drop_out(Student_drop_outDto student_drop_out) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call student_drop_out_insert(?, ?)}");
        CS.setInt(1,student_drop_out.getId_student());
        CS.setInt(2,student_drop_out.getId_drop_out_cause());

        CS.executeUpdate();
    }

    @Override
    public void updateStudent_drop_out(Student_drop_outDto student_drop_out) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call student_drop_out_update(?,?,?)}");
        CS.setInt(1,student_drop_out.getId_student());
        CS.setInt(2,student_drop_out.getId_drop_out_cause());
        CS.setInt(3,student_drop_out.getId_student_drop_out());
        CS.execute();
        CS.close();
    }

    @Override
    public List<Student_drop_outDto> listStudent_drop_out() throws SQLException {
        List<Student_drop_outDto> student_drop_outList = new ArrayList<Student_drop_outDto>();
        ResultSet rs = jdbcTemplate.getDataSource().getConnection().createStatement().executeQuery(
                "SELECT * FROM student_drop_out");

        while(rs.next()){
            student_drop_outList.add(new Student_drop_outDto(rs.getInt("id_student")
                    ,rs.getInt("id_drop_out_cause")
                    ,rs.getInt("id_student_drop_out")
                    ,studentService.getStudentById(rs.getInt("id_student"))
                    ,drop_out_causeService.getDrop_out_causeById(rs.getInt("id_drop_out_cause"))));
        }
        return student_drop_outList;
    }

    @Override
    public Student_drop_outDto getStudent_drop_outDtoById(Integer id) throws SQLException {
        Student_drop_outDto student_drop_out = null;

        PreparedStatement pstmt = jdbcTemplate.getDataSource().getConnection().prepareStatement(
                "SELECT * FROM student_drop_out where id_student_drop_out = ?");

        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            student_drop_out = new Student_drop_outDto(rs.getInt("id_student")
                    ,rs.getInt("id_drop_out_cause")
                    ,rs.getInt("id_student_drop_out")
                    ,studentService.getStudentById(rs.getInt("id_student"))
                    ,drop_out_causeService.getDrop_out_causeById(rs.getInt("id_drop_out_cause")));
        }
        return student_drop_out;
    }

    @Override
    public void deleteStudent_drop_outDto(Integer id) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall(
                "{call student_drop_out_delete(?)}");

        CS.setInt(1, id);
        CS.executeUpdate();
    }
}
