package cu.edu.cujae.backend.service;

import cu.edu.cujae.backend.core.dto.Student_historyDto;
import cu.edu.cujae.backend.core.service.CourseService;
import cu.edu.cujae.backend.core.service.GroupsService;
import cu.edu.cujae.backend.core.service.Student_historyService;
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
public class Student_historyServiceImpl implements Student_historyService {

    @Autowired
private GroupsService groupsService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void createStudent_history(Student_historyDto student_history) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call student_history_insert(?, ?, ?, ?)}");
        CS.setInt(1,student_history.getId_student_history());
        CS.setInt(2,student_history.getId_group());
        CS.setInt(3,student_history.getNum_list());
        CS.setInt(4,student_history.getId_course());

        CS.executeUpdate();
    }

    @Override
    public void updateStudent_history(Student_historyDto student_history) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call student_history_update(?,?,?,?)}");
        CS.setInt(1,student_history.getId_student_history());
        CS.setInt(2,student_history.getId_group());
        CS.setInt(3,student_history.getNum_list());
        CS.setInt(4,student_history.getId_course());
        CS.execute();
        CS.close();
    }

    @Override
    public List<Student_historyDto> listStudent_history() throws SQLException {
        List<Student_historyDto> student_historyList = new ArrayList<Student_historyDto>();
        ResultSet rs = jdbcTemplate.getDataSource().getConnection().createStatement().executeQuery(
                "SELECT * FROM student_history");

        while(rs.next()){
            student_historyList.add(new Student_historyDto(rs.getInt("id_student_history")
                    ,rs.getInt("id_group")
                    ,rs.getInt("num_list")
                    ,rs.getInt("id_course")
                    ,groupsService.getGroupsById(rs.getInt("id_group"))
                    ,courseService.getCourseById(rs.getInt("id_course"))));
        }
        return student_historyList;
    }

    @Override
    public Student_historyDto getStudent_historyById(Integer Id) throws SQLException {
        Student_historyDto student_history = null;

        PreparedStatement pstmt = jdbcTemplate.getDataSource().getConnection().prepareStatement(
                "SELECT * FROM student_history where id_student_history = ?");

        pstmt.setInt(1, Id);

        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            student_history = new Student_historyDto(rs.getInt("id_student_history")
                    ,rs.getInt("id_group")
                    ,rs.getInt("num_list")
                    ,rs.getInt("id_course")
                    ,groupsService.getGroupsById(rs.getInt("id_group"))
                    ,courseService.getCourseById(rs.getInt("id_course")));
        }
        return student_history;
    }

    @Override
    public void deleteStudent_historyDto(Integer id) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall(
                "{call student_history_delete(?)}");

        CS.setInt(1, id);
        CS.executeUpdate();
    }

}
