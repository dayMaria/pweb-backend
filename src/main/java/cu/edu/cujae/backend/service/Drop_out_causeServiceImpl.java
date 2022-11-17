package cu.edu.cujae.backend.service;

import cu.edu.cujae.backend.core.dto.Drop_out_causeDto;
import cu.edu.cujae.backend.core.service.Drop_out_causeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class Drop_out_causeServiceImpl implements Drop_out_causeService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createDrop_out_cause(Drop_out_causeDto drop_out_cause) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call drop_out_cause_insert(?,?)}");
        CS.setInt(1,drop_out_cause.getId_drop_out_cause());
        CS.setString(2,drop_out_cause.getDrop_out_cause());


        CS.executeUpdate();
    }

    @Override
    public void updateDrop_out_cause(Drop_out_causeDto drop_out_cause) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call drop_out_cause_update(?,?)}");
        CS.setInt(1,drop_out_cause.getId_drop_out_cause());
        CS.setString(2,drop_out_cause.getDrop_out_cause());
        CS.execute();
        CS.close();
    }

    @Override
    public List<Drop_out_causeDto> listDrop_out_cause() throws SQLException {
        List<Drop_out_causeDto> drop_out_causeList = new ArrayList<Drop_out_causeDto>();
        ResultSet rs = jdbcTemplate.getDataSource().getConnection().createStatement().executeQuery(
                "SELECT * FROM drop_out_cause");

        while(rs.next()){
            drop_out_causeList.add(new Drop_out_causeDto(rs.getInt("id_droup_out_cause")
                    ,rs.getString("drop_out_cause")));
        }
        return drop_out_causeList;
    }

    @Override
    public Drop_out_causeDto getDrop_out_causeById(Integer Id) throws SQLException {
        Drop_out_causeDto drop_out_cause = null;

        PreparedStatement pstmt = jdbcTemplate.getDataSource().getConnection().prepareStatement(
                "SELECT * FROM drop_out_cause where id_droup_out_cause = ?");

        pstmt.setInt(1, Id);

        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            drop_out_cause = new Drop_out_causeDto(rs.getInt("id_droup_out_cause")
                    ,rs.getString("drop_out_cause"));
        }
        return drop_out_cause;
    }

    @Override
    public void deleteDrop_out_cause(Integer id) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall(
                "{call drop_out_cause_delete(?)}");

        CS.setInt(1, id);
        CS.executeUpdate();
    }
}
