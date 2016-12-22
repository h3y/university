package com.server.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Slavik Glodan on 09.12.2016.
 */
@Entity
@Table(name = "faculty")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name", nullable = false, length = 128)
    private String name;
    @Column(name = "short_name", nullable = false, length = 64)
    private String shortName;
    @OneToMany(mappedBy = "faculty")
    private List<Speciality> specialities = new ArrayList<>();
    @OneToMany(mappedBy = "faculty")
    private List<Department> departments = new ArrayList<>();
}
