package com.std.cation.controller;

import com.std.cation.payload.GroupPayload;
import com.std.cation.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("group")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    private ResponseEntity<?> get() {
        return ResponseEntity.ok(groupService.get());
    }

    @PostMapping
    private ResponseEntity<?> create(@RequestBody @Valid GroupPayload payload) {
        return ResponseEntity.ok(groupService.create(payload));
    }
}
