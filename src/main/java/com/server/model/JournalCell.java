package com.server.model;

import javax.persistence.*;

/**
 * Created by Slavik Glodan on 09.12.2016.
 */
@Entity
@Table(name = "journal_cell")
public class JournalCell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "journal_column_id")
    private JournalColumn journalColumn;
    @ManyToOne(optional = false)
    private Student student;
    @Column(name = "locked", columnDefinition = "tinyint(1) default 0", nullable = false)
    private boolean locked;
    @Column(name = "attendance", columnDefinition = "tinyint(1) default 1", nullable = false)
    private boolean attendance;
    @Column(name = "mark")
    private double mark;
}
