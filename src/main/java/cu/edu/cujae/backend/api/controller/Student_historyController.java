package cu.edu.cujae.backend.api.controller;

import cu.edu.cujae.backend.core.dto.Student_historyDto;
import cu.edu.cujae.backend.core.service.Student_historyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/student_history")
public class Student_historyController {
    @Autowired
    private Student_historyService student_historyService;

    @GetMapping("/")
    public ResponseEntity<List<Student_historyDto>> getStudent_history() throws SQLException {
        List<Student_historyDto> student_historyList =student_historyService.listStudent_history();
        return ResponseEntity.ok(student_historyList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student_historyDto> getStudent_historyById(@PathVariable Integer id) throws SQLException {
        Student_historyDto student_history = student_historyService.getStudent_historyById(id);
        return ResponseEntity.ok(student_history);
    }

    @PostMapping("/")
    public ResponseEntity<String> create(@RequestBody Student_historyDto student_history) throws SQLException {
        student_historyService.createStudent_history(student_history);
        return ResponseEntity.ok("Student_history Created");
    }

    @PutMapping("/")
    public ResponseEntity<String> update(@RequestBody Student_historyDto student_history) throws SQLException {
        student_historyService.updateStudent_history(student_history);
        return ResponseEntity.ok("Student_history Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) throws SQLException {
        student_historyService.deleteStudent_historyDto(id);
        return ResponseEntity.ok("Student_history deleted");
    }
}
