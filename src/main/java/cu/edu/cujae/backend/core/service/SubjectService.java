package cu.edu.cujae.backend.core.service;

import cu.edu.cujae.backend.core.dto.SubjectDto;

import java.sql.SQLException;
import java.util.List;

public interface SubjectService {

    void createSubject(SubjectDto subject) throws SQLException;

    void updateSubject(SubjectDto subject);

    List<SubjectDto> listSubject() throws SQLException;

    SubjectDto getSubjectById(Integer id) throws SQLException;

    void deleteSubject(Integer id) throws SQLException;
}
