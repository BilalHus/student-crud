package com.std.cation.service;

import com.std.cation.dto.StudentDTO;
import com.std.cation.exception.NotFoundException;
import com.std.cation.model.Group;
import com.std.cation.model.Student;
import com.std.cation.payload.StudentPayload;
import com.std.cation.repository.GroupRepository;
import com.std.cation.repository.StudentRepository;
import com.std.cation.util.StudentPayloadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final GroupRepository groupRepository;

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(GroupRepository groupRepository,
                              StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDTO get(long id) {
        return new StudentDTO(
                studentRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Requested student does not exist"))
        );
    }

    @Override
    public List<StudentDTO> getGroup(long groupId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new NotFoundException("Requested group does not exist"));

        return studentRepository.findAllByGroup(group).stream()
                .map(StudentDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO create(StudentPayload payload) {
        Group group = groupRepository.findById(payload.getGroupId())
                .orElseThrow(() -> new NotFoundException("Group was not found"));

        StudentPayloadMapper mapper = new StudentPayloadMapper(payload);

        Student student = mapper.toStudent(new Student(), group);

        return new StudentDTO(studentRepository.save(student));
    }

    @Override
    public StudentDTO update(long id, StudentPayload payload) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Requested student does not exist"));
        Group group = groupRepository.findById(payload.getGroupId())
                .orElseThrow(() -> new NotFoundException("Group was not found"));

        StudentPayloadMapper mapper = new StudentPayloadMapper(payload);
        student = mapper.toStudent(student, group);

        return new StudentDTO(studentRepository.save(student));
    }

    @Override
    public void delete(long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Requested student does not exist"));
        studentRepository.delete(student);
    }
}
