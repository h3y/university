package com.server.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Slavik Glodan on 09.12.2016.
 */
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name", nullable = false, length = 128)
    private String name;
    @ManyToOne(optional = false)//TODO Дізнатись чи може існувати предмет без кафедри!
    private Department department;
    @OneToMany(mappedBy = "subject")
    private List<TypeSubject> typeSubjects = new ArrayList<>();
    @OneToMany(mappedBy = "subject")
    private List<Journal> journals = new ArrayList<>();
}
