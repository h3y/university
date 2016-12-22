package com.server.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Slavik Glodan on 09.12.2016.
 */
@Entity
@Table(name = "`group`")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name", length = 64)
    private String name;
    @Column(name = "entry_year", length = 4)
    private int entryYear;
    @Column(name = "prefix", length = 4)
    private String prefix;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Speciality speciality;
    @ManyToMany(mappedBy = "groups")
    private List<Student> students = new ArrayList<>();
    @OneToMany(mappedBy = "group")
    private List<Journal> journals = new ArrayList<>();
}
