package com.std.cation.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "groups")
@Getter @Setter @NoArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "group_name", nullable = false, unique = true)
    private String groupName;

    @Column(name = "start_year", nullable = false)
    private int startYear;

    @Column(name = "end_year", nullable = false)
    private int endYear;

    @Column(name = "faculty", nullable = false)
    private String faculty;
}
