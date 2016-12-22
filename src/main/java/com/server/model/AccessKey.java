package com.server.model;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Created by Slavik Glodan on 09.12.2016.
 */
@Entity
@Table(name = "access_key")
public class AccessKey {
    @Id
    private int id;
    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(name = "id")
    private User user;
    @Column(name = "`key`", nullable = false, length = 128)
    private String key;
    @Column(name = "last_use", nullable = false)
    private Instant instant;

}
