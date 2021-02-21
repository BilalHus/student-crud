package com.std.cation.dto;

import com.std.cation.model.Student;
import com.std.cation.model.enumeration.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor
public class StudentDTO {

    private Long id;

    private String fullName;

    private LocalDateTime dateOfBirth;

    private String address;

    private Gender gender;

    private GroupDTO group;

    public StudentDTO(Student student) {
        this.id = student.getId();
        this.fullName = student.getFullName();
        this.dateOfBirth = student.getDateOfBirth();
        this.address = student.getAddress();
        this.gender = student.getGender();
        this.group = new GroupDTO(student.getGroup());
    }
}
