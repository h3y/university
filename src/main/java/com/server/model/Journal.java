package com.server.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Slavik Glodan on 09.12.2016.
 */
@Entity
@Table(name = "journal")
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne(optional = false)
    private Group group;
    @ManyToOne(optional = false)
    private Subject subject;
    @OneToOne(mappedBy = "journal")
    private EducationProcess educationProcess;
    @ManyToMany(mappedBy = "journals")
    private List<Teacher> teachers = new ArrayList<>();
    @OneToMany(mappedBy = "journal")
    private List<JournalColumn> journalColumns = new ArrayList<>();

}
