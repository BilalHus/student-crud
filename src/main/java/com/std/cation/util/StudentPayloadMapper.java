package com.std.cation.util;

import com.std.cation.model.Group;
import com.std.cation.model.Student;
import com.std.cation.payload.StudentPayload;

public class StudentPayloadMapper {

    private final StudentPayload payload;

    public StudentPayloadMapper(StudentPayload payload) {
        this.payload = payload;
    }

    public Student toStudent(Student student, Group group) {
        student.setFullName(payload.getFullName());
        student.setDateOfBirth(payload.getDateOfBirth());
        student.setAddress(payload.getAddress());
        student.setGender(payload.getGender());
        student.setGroup(group);
        return student;
    }

}
