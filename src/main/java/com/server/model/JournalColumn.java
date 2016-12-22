package com.server.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Slavik Glodan on 09.12.2016.
 */
@Entity
@Table(name = "journal_column")
public class JournalColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @ManyToOne(optional = false)
    private Journal journal;
    @Column(name = "date_lesson", nullable = false)
    private LocalDateTime dateLesson;
    @Column(name = "name", nullable = false)
    private String name;
    @OneToMany(mappedBy = "journalColumn")
    private List<JournalCell> journalCells = new ArrayList<>();
}
