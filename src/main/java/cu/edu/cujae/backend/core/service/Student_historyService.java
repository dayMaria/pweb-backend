package cu.edu.cujae.backend.core.service;

import cu.edu.cujae.backend.core.dto.Student_historyDto;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

public interface Student_historyService {
    void createStudent_history(Student_historyDto student_history) throws SQLException;

    void updateStudent_history(Student_historyDto student_history);

    List<Student_historyDto> listStudent_history() throws SQLException;

    Student_historyDto getStudent_historyById(Integer Id) throws SQLException;

    void deleteStudent_historyDto(Integer id) throws SQLException;
}
