package com.std.cation.dto;

import com.std.cation.model.Group;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GroupDTO {

    private Long id;

    private String groupName;

    private int startYear;

    private int endYear;

    private String faculty;

    public GroupDTO(Group group) {
        this.id = group.getId();
        this.groupName = group.getGroupName();
        this.startYear = group.getStartYear();
        this.endYear = group.getEndYear();
        this.faculty = group.getFaculty();
    }
}
