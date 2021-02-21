package com.std.cation.service;

import com.std.cation.dto.StudentDTO;
import com.std.cation.payload.StudentPayload;

import java.util.List;

public interface StudentService {

    StudentDTO get(long id);

    List<StudentDTO> getGroup(long groupId);

    StudentDTO create(StudentPayload payload);

    StudentDTO update(long id, StudentPayload payload);

    void delete(long id);
}
