package cu.edu.cujae.backend.service;

import cu.edu.cujae.backend.core.dto.CourseDto;
import cu.edu.cujae.backend.core.dto.GroupsDto;
import cu.edu.cujae.backend.core.service.GroupsService;
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
public class GroupsServiceImpl implements GroupsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void createGroups(GroupsDto groups) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call groups_insert(?, ?, ?)}");
        CS.setInt(1,groups.getId_group());
        CS.setString(2, groups.getGroup_name());
        CS.setInt(3, groups.getId_year());

        CS.executeUpdate();
    }

    @Override
    public void updateGroups(GroupsDto groups) {

    }

    @Override
    public List<GroupsDto> listGroups() throws SQLException {
        List<GroupsDto> groupsList = new ArrayList<GroupsDto>();
        ResultSet rs = jdbcTemplate.getDataSource().getConnection().createStatement().executeQuery(
                "SELECT * FROM groups");

        while(rs.next()){
            groupsList.add(new GroupsDto(rs.getInt("id_groups")
                    ,rs.getString("group_name")
                    ,rs.getInt("id_year")));
        }
        return groupsList;
    }

    @Override
    public GroupsDto getGroupsById(Integer id) throws SQLException {
        GroupsDto groups = null;

        PreparedStatement pstmt = jdbcTemplate.getDataSource().getConnection().prepareStatement(
                "SELECT * FROM groups where id_groups = ?");

        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            groups = new GroupsDto(rs.getInt("id_groups")
                    ,rs.getString("group_name")
                    ,rs.getInt("id_year"));
        }
        return groups;
    }

    @Override
    public void deleteGroups(Integer id) throws SQLException {
        CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall(
                "{call groups_delete(?)}");

        CS.setInt(1, id);
        CS.executeUpdate();
    }
}
