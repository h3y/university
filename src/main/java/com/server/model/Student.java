package com.server.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Slavik Glodan on 09.12.2016.
 */
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "student_code", nullable = false, length = 64, unique = true)
    private String studentCode;
    @Column(name = "address")
    private String address;
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column(name = "phone", length = 64)
    private String phone;
    @OneToOne(optional = false)
    private User user;
    @ManyToMany()
    private List<Group> groups = new ArrayList<>();
    @OneToMany(mappedBy = "student")
    private List<JournalCell> journalCells = new ArrayList<>();

}
