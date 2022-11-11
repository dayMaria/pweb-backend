package cu.edu.cujae.backend.service;

import cu.edu.cujae.backend.core.dto.Subject_historyDto;
import cu.edu.cujae.backend.core.service.Subject_historyService;
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
public class Subject_historyServiceImpl implements Subject_historyService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void createSubject_history(Subject_historyDto subject_history) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call subject_history_insert(?, ?, ?)}");
        CS.setInt(1, subject_history.getId_subject_history());
        CS.setString(2,subject_history.getSubject_history_type());
        CS.setInt(3, subject_history.getId_course());

        CS.executeUpdate();
    }

    @Override
    public void updateSubject_history(Subject_historyDto subject_history) {

    }

    @Override
    public List<Subject_historyDto> listSubject_history() throws SQLException {
        List<Subject_historyDto> subject_historyList = new ArrayList<Subject_historyDto>();
        ResultSet rs = jdbcTemplate.getDataSource().getConnection().createStatement().executeQuery(
                "SELECT * FROM subject_history");

        while(rs.next()){
            subject_historyList.add(new Subject_historyDto(rs.getInt("id_subject_history")
                    ,rs.getString("subject_history_type")
                    ,rs.getInt("id_course")));
        }
        return subject_historyList;
    }

    @Override
    public Subject_historyDto getSubject_historyById(Integer id) throws SQLException {
        Subject_historyDto subject_history = null;

        PreparedStatement pstmt = jdbcTemplate.getDataSource().getConnection().prepareStatement(
                "SELECT * FROM subject_history where id_subject_history = ?");

        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            subject_history = new Subject_historyDto(rs.getInt("id_subject_history")
                    ,rs.getString("subject_history_type")
                    ,rs.getInt("id_course"));
        }
        return subject_history;
    }

    @Override
    public void deleteSubject_history(Integer id) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall(
                "{call subject_history_delete(?)}");

        CS.setInt(1, id);
        CS.executeUpdate();
    }
}
