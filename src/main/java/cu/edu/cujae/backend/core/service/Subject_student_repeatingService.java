package cu.edu.cujae.backend.core.service;

import cu.edu.cujae.backend.core.dto.Subject_student_repeatingDto;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

public interface Subject_student_repeatingService {

    void createSubject_student_repeating(Subject_student_repeatingDto objects) throws SQLException;

    void updateSubject_student_repeating(Subject_student_repeatingDto objects) throws SQLException;

    List<Subject_student_repeatingDto> listSubject_student_repeating() throws SQLException;

    Subject_student_repeatingDto getSubject_student_repeatingById(Integer id) throws SQLException;

    void deleteSubject_student_repeating(Integer id) throws SQLException;
}
