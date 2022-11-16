package cu.edu.cujae.backend.service;

import cu.edu.cujae.backend.core.dto.TownDto;
import cu.edu.cujae.backend.core.service.TownService;
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
public class TownServiceImpl implements TownService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void createTown(TownDto town) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call town_insert(?, ?)}");
        CS.setInt(1, town.getId_town());
        CS.setString(2,town.getTown());

        CS.executeUpdate();
    }

    @Override
    public void updateTown(TownDto town) {

    }

    @Override
    public List<TownDto> listTown() throws SQLException {
        List<TownDto> townList = new ArrayList<TownDto>();
        ResultSet rs = jdbcTemplate.getDataSource().getConnection().createStatement().executeQuery(
                "SELECT * FROM town");

        while(rs.next()){
            townList.add(new TownDto(rs.getInt("id_town")
                    ,rs.getString("town")));
        }
        return townList;
    }

    @Override
    public TownDto getTownById(Integer id) throws SQLException {
        TownDto town = null;

        PreparedStatement pstmt = jdbcTemplate.getDataSource().getConnection().prepareStatement(
                "SELECT * FROM town where id_town = ?");

        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            town = new TownDto(rs.getInt("id_town")
                    ,rs.getString("town"));
        }
        return town;
    }

    @Override
    public void deleteTown(Integer id) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall(
                "{call town_delete(?)}");

        CS.setInt(1, id);
        CS.executeUpdate();
    }
}
