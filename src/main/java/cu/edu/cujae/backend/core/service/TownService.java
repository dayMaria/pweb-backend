package cu.edu.cujae.backend.core.service;

import cu.edu.cujae.backend.core.dto.TownDto;

import java.sql.SQLException;
import java.util.List;

public interface TownService {

    void createTown(TownDto town) throws SQLException;

    void updateTown(TownDto town);

    List<TownDto> listTown() throws SQLException;

    TownDto getTownById(Integer id) throws SQLException;

    void deleteTown(Integer id) throws SQLException;
}
