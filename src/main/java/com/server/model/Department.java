package com.server.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Slavik Glodan on 09.12.2016.
 */
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name", nullable = false, length = 128)
    private String name;
    @ManyToOne(optional = false)
    private Faculty faculty;
    @ManyToMany(mappedBy = "departments")
    private List<Teacher> teachers = new ArrayList<>();
    @OneToMany(mappedBy = "department")
    private List<Subject> subjects = new ArrayList<>();

}
