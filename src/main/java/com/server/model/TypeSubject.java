package com.server.model;

import javax.persistence.*;

/**
 * Created by Slavik Glodan on 09.12.2016.
 */
@Entity
@Table(name = "type_subject")
public class TypeSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne(optional = false)
    private Subject subject;
    @Column(name = "type_study", nullable = false)
    private TypeStudy typeStudy;
    private enum  TypeStudy { lecture, laboratory, seminar }
}
