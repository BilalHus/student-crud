package com.std.cation.controller;

import com.std.cation.payload.StudentPayload;
import com.std.cation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable long id) {
        return ResponseEntity.ok(studentService.get(id));
    }

    @GetMapping
    public ResponseEntity<?> getGroup(@RequestParam long groupId) {
        return ResponseEntity.ok(studentService.getGroup(groupId));
    }

    @PostMapping
    private ResponseEntity<?> create(@RequestBody @Valid StudentPayload payload) {
        return ResponseEntity.ok(studentService.create(payload));
    }

    @PutMapping("{id}")
    private ResponseEntity<?> update(@PathVariable long id, @RequestBody @Valid StudentPayload payload) {
        return ResponseEntity.ok(studentService.update(id, payload));
    }


    @DeleteMapping("{id}")
    private ResponseEntity<?> delete(@PathVariable long id) {
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
