package com.ocugene.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "request", schema = "public")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    Integer requestId;

    @Column(name = "username")
    String username;

    @Column(name = "email")
    String email;

    @Column(name = "password")
    String password;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "contact_number")
    String contactNumber;

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
