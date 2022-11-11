package cu.edu.cujae.backend.api.controller;


import cu.edu.cujae.backend.core.dto.Subject_historyDto;
import cu.edu.cujae.backend.core.service.Subject_historyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/subject_history")
public class Subject_historyController {
    @Autowired
    private Subject_historyService subject_historyService;

    @GetMapping("/")
    public ResponseEntity<List<Subject_historyDto>> getSubject_history() throws SQLException {
        List<Subject_historyDto> subject_historyList = subject_historyService.listSubject_history();
        return ResponseEntity.ok(subject_historyList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subject_historyDto> getSubject_historyById(@PathVariable Integer id) throws SQLException {
        Subject_historyDto subject_history = subject_historyService.getSubject_historyById(id);
        return ResponseEntity.ok(subject_history);
    }

    @PostMapping("/")
    public ResponseEntity<String> create(@RequestBody Subject_historyDto subject_history) throws SQLException {
        subject_historyService.createSubject_history(subject_history);
        return ResponseEntity.ok("Subject_history Created");
    }

    @PutMapping("/")
    public ResponseEntity<String> update(@RequestBody Subject_historyDto subject_history) throws SQLException {
        subject_historyService.updateSubject_history(subject_history);
        return ResponseEntity.ok("Subject_history Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) throws SQLException {
        subject_historyService.deleteSubject_history(id);
        return ResponseEntity.ok("Subject_history deleted");
    }
}
