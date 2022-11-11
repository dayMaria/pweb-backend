package cu.edu.cujae.backend.core.service;

import cu.edu.cujae.backend.core.dto.YearDto;

import java.sql.SQLException;
import java.util.List;

public interface YearService {
    void createYear(YearDto year) throws SQLException;

    void updateYear(YearDto year);

    List<YearDto> listYear() throws SQLException;

    YearDto getYearById(Integer id) throws SQLException;

    void deleteYear(Integer id) throws SQLException;
}
