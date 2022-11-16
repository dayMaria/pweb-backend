package cu.edu.cujae.backend.service;

import cu.edu.cujae.backend.core.dto.CourseDto;
import cu.edu.cujae.backend.core.dto.SemesterDto;
import cu.edu.cujae.backend.core.service.SemesterService;
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
public class SemesterServiceImpl implements SemesterService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void createSemester(SemesterDto semester) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call semester_insert(?, ?, ?, ?)}");
        CS.setInt(1,semester.getId_semester());
        CS.setString(2,semester.getSemester());

        CS.setInt(3,semester.getId_year());
        CS.setInt(4,semester.getId_course());

        CS.executeUpdate();
    }

    @Override
    public void updateSemester(SemesterDto semester) {

    }

    @Override
    public List<SemesterDto> listSemester() throws SQLException {
        List<SemesterDto> semesterList = new ArrayList<SemesterDto>();
        ResultSet rs = jdbcTemplate.getDataSource().getConnection().createStatement().executeQuery(
                "SELECT * FROM semester");

        while(rs.next()){
            semesterList.add(new SemesterDto(rs.getInt("id_semester")
                    ,rs.getString("semester")
                    ,rs.getInt("id_year")
                    ,rs.getInt("id_course")));
        }
        return semesterList;
    }

    @Override
    public SemesterDto getSemesterById(Integer id) throws SQLException {
        SemesterDto semester = null;

        PreparedStatement pstmt = jdbcTemplate.getDataSource().getConnection().prepareStatement(
                "SELECT * FROM semester where id_semester = ?");

        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            semester = new SemesterDto(rs.getInt("id_semester")
                    ,rs.getString("semester")
                    ,rs.getInt("id_year")
                    ,rs.getInt("id_course"));
        }
        return semester;
    }

    @Override
    public void deleteSemester(Integer id) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall(
                "{call semester_delete(?)}");

        CS.setInt(1, id);
        CS.executeUpdate();
    }
}
