package cu.edu.cujae.backend.core.service;

import cu.edu.cujae.backend.core.dto.CourseDto;


import java.sql.SQLException;
import java.util.List;


public interface CourseService {

    void createCourse(CourseDto courseDto) throws SQLException;

    void updateCourse(CourseDto courseDto);

    List<CourseDto> listCourse() throws SQLException;

    CourseDto getCourseById(Integer id) throws SQLException;

    void deleteCourse(Integer id) throws SQLException;
}
