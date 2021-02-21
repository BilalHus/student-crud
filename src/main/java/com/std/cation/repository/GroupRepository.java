package com.std.cation.repository;

import com.std.cation.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    boolean existsByGroupName(String groupName);
}
