package com.server.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Slavik Glodan on 09.12.2016.
 */
@Entity
@Table(name = "speciality")
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "code", nullable = false, length = 64, unique = true)
    private String code;
    @Column(name = "name", nullable = false, length = 128)
    private String name;
    @ManyToOne(optional = false)
    private Faculty faculty;
}

