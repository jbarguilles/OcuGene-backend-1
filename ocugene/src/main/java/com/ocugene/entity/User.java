package com.ocugene.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @JsonProperty("user_id")
    Integer userId;

    @Column(name = "user_name")
    @JsonProperty("user_name")
    String userName;

    @Column(name = "user_email")
    @JsonProperty("user_email")
    String userEmail;

    @Column(name = "user_password")
    @JsonProperty("user_password")
    String userPassword;
}
