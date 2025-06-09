package com.minglemongles.minglejam.user.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import lombok.*;

import java.sql.Timestamp;


@Entity
@Table(name = "tb_user")
@Getter
@Setter
@ToSring
public class User {
    @Id
    @GeneratedValue(Strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_gender")
    private String userGender;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_password")
    private String userPWD;

    @Column(name = "user_nickname")
    private String userNickName;

    @Column(name = "user_flag")
    private Boolean userState;

    @Column(name = "user_dormant_status")
    private String userDormantState;

    @Column(name = "created_at")
    private Timestamp userCreated;

    @Column(name = "updated_at")
    private Timestamp userUpdated;


}
