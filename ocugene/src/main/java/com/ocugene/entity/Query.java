package com.ocugene.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "query", schema = "registrydatabase")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Query {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "query_id")
    private Integer queryID;

    @Column(name = "query_email")
    private String email;

    @Column(name = "query_message")
    private String message;

    @Column(name = "responded_flag")
    private boolean respondedFlag;

}
