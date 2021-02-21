package com.std.cation.service;

import com.std.cation.dto.GroupDTO;
import com.std.cation.payload.GroupPayload;

import java.util.List;

public interface GroupService {
    GroupDTO create(GroupPayload groupPayload);
    List<GroupDTO> get();
}
