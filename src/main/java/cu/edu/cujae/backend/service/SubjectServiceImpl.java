package cu.edu.cujae.backend.service;

import cu.edu.cujae.backend.core.dto.SubjectDto;
import cu.edu.cujae.backend.core.service.SubjectService;
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
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createSubject(SubjectDto subject) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call subject_insert(?, ?, ?)}");
        CS.setInt(1, subject.getId_subject());
        CS.setString(2,subject.getSubject());
        CS.setInt(3, subject.getId_semester());

        CS.executeUpdate();
    }

    @Override
    public void updateSubject(SubjectDto subject) {

    }

    @Override
    public List<SubjectDto> listSubject() throws SQLException {
        List<SubjectDto> subjectList = new ArrayList<SubjectDto>();
        ResultSet rs = jdbcTemplate.getDataSource().getConnection().createStatement().executeQuery(
                "SELECT * FROM subject");

        while(rs.next()){
            subjectList.add(new SubjectDto(rs.getInt("id_subject")
                    ,rs.getString("subject")
                    ,rs.getInt("id_semester")));
        }
        return subjectList;
    }

    @Override
    public SubjectDto getSubjectById(Integer id) throws SQLException {
        SubjectDto subject = null;

        PreparedStatement pstmt = jdbcTemplate.getDataSource().getConnection().prepareStatement(
                "SELECT * FROM subject where id_subject = ?");

        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            subject = new SubjectDto(rs.getInt("id_subject")
                    ,rs.getString("subject")
                    ,rs.getInt("id_semester"));
        }
        return subject;
    }

    @Override
    public void deleteSubject(Integer id) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall(
                "{call subject_delete(?)}");

        CS.setInt(1, id);
        CS.executeUpdate();
    }
}
