package cu.edu.cujae.backend.core.service;

import cu.edu.cujae.backend.core.dto.SemesterDto;

import java.sql.SQLException;
import java.util.List;

public interface SemesterService {

    void createSemester(SemesterDto semester) throws SQLException;

    void updateSemester(SemesterDto semester);

    List<SemesterDto> listSemester() throws SQLException;

    SemesterDto getSemesterById(Integer id) throws SQLException;

    void deleteSemester(Integer id) throws SQLException;
}
