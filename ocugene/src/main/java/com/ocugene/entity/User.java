package com.ocugene.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ocugene.entity.nonFormEntities.VerificationCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user", schema = "public")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Integer userId;

    @Column(name = "username")
    String username;

    @Column(name = "user_password")
    String userPassword;

    @Column(name = "user_type")
    String userType;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "contact_number")
    String contactNumber;

    @Column(name = "email")
    String email;

    @JsonIgnore
    @OneToMany(mappedBy = "ocugeneUser", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id desc")
    private List<VerificationCode> verificationCodes = new ArrayList<>();
}
