package cu.edu.cujae.backend.core.service;

import cu.edu.cujae.backend.core.dto.Subject_historyDto;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

public interface Subject_historyService {

    void createSubject_history(Subject_historyDto subject_history) throws SQLException;

    void updateSubject_history(Subject_historyDto subject_history);

    List<Subject_historyDto> listSubject_history() throws SQLException;

    Subject_historyDto getSubject_historyById(Integer id) throws SQLException;

    void deleteSubject_history(Integer id) throws SQLException;
}
