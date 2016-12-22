package com.server.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Slavik Glodan on 09.12.2016.
 */
@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "teacher_status", length = 128)
    private String teacherStatus;
    @Column(name = "degree", length = 128)
    private String degree;
    @OneToOne(optional = false)
    private User user;
    @ManyToMany()
    private List<Department> departments = new ArrayList<>();
    @ManyToMany()
    private List<Journal> journals = new ArrayList<>();

}
