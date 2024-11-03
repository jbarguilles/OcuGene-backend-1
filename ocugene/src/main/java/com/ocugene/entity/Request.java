package com.ocugene.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "requests", schema = "registrydatabase")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    Integer requestId;

    @Column(name = "email")
    String email;

    @Column(name = "password")
    String password;

    @Column(name = "user_type")
    String userType;

    @Column(name = "supp_docu")
    String supportingDocuments;

    @Column(name = "institution")
    String institution;

    @Column(name = "message")
    String message;

    @Column(name = "status")
    String status;
}
