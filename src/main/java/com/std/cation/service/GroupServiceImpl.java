package com.std.cation.service;

import com.std.cation.dto.GroupDTO;
import com.std.cation.exception.ConflictException;
import com.std.cation.model.Group;
import com.std.cation.payload.GroupPayload;
import com.std.cation.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public GroupDTO create(GroupPayload groupPayload) {
        if (groupRepository.existsByGroupName(groupPayload.getGroupName())) {
            throw new ConflictException("Group with given group name already exists");
        }

        Group group = new Group();
        group.setGroupName(groupPayload.getGroupName());
        group.setStartYear(groupPayload.getStartYear());
        group.setEndYear(groupPayload.getStartYear() + 4);
        group.setFaculty(groupPayload.getFaculty());

        return new GroupDTO(groupRepository.save(group));
    }

    @Override
    public List<GroupDTO> get() {
        return groupRepository.findAll().stream().map(GroupDTO::new).collect(Collectors.toList());
    }
}
