package com.zue.be.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "declarations")
@Data
public class Declaration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grant_code")
    private User grantUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proceed_code")
    private User proceedUser;

    private Time startTime;
    private Time endTime;
    private Boolean isCompleted;
}
