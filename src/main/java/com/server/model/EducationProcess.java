package com.server.model;

import javax.persistence.*;

/**
 * Created by Slavik Glodan on 09.12.2016.
 */
@Entity
@Table(name = "education_process")
public class EducationProcess {
    @Id
    private int id;
    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(name = "id")
    private Journal journal;
    @Column(name = "semester", nullable = false)
    private int semester;
    @Column(name = "lecture_time", nullable = false, columnDefinition = "double default 0")
    private double lectureTime;
    @Column(name = "laboratory_time", nullable = false, columnDefinition = "double default 0")
    private double laboratoryTime;
    @Column(name = "seminar_time", nullable = false, columnDefinition = "double default 0")
    private double seminarTime;
}
