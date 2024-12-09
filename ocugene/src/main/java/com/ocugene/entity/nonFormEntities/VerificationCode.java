package com.ocugene.entity.nonFormEntities;

import com.ocugene.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "verification_code")
@Getter
@Setter
public class VerificationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "created_timestamp", nullable = false)
    private Date createdTimestamp;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User ocugeneUser;

}
