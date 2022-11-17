package cu.edu.cujae.backend.core.service;

import cu.edu.cujae.backend.core.dto.StudentDto;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {

    void createStudent(StudentDto student) throws SQLException;

    void updateStudent(StudentDto student) throws SQLException;

    List<StudentDto> listStudent() throws SQLException;

    StudentDto getStudentById(Integer id) throws SQLException;

    void deleteStudent(Integer id) throws SQLException;
}
