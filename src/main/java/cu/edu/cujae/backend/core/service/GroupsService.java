package cu.edu.cujae.backend.core.service;

import cu.edu.cujae.backend.core.dto.GroupsDto;

import java.sql.SQLException;
import java.util.List;

public interface GroupsService {
    void createGroups(GroupsDto groups) throws SQLException;

    void updateGroups(GroupsDto groups) throws SQLException;

    List<GroupsDto> listGroups() throws SQLException;

    GroupsDto getGroupsById(Integer id) throws SQLException;

    void deleteGroups(Integer id) throws SQLException;
}
