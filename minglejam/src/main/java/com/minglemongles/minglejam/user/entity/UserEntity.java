package com.minglemongles.minglejam.user.entity;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tb_user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserEntity {
    @Id
    @Column(name = "user_id", columnDefinition = "VARCHAR(36)")
    private String userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_gender", nullable = false)
    private String userGender;  // 성병 enum 관리 수정 고민 중

    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @Column(name = "user_password", nullable = false)
    private String userPWD;

    @Column(name = "user_nickname", nullable = false)
    private String userNickName;

    @Column(name = "user_flag", nullable = false)
    private Boolean userState;

    @Column(name = "user_dormant_status", nullable = false)
    private Boolean dormantState;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @PrePersist
    public void uuid() {
        if (this.userId == null) {
            this.userId = UUID.randomUUID().toString();
        }
        if (userState == null) userState = true;
        if (dormantState == null) dormantState = true;
        if (this.createdAt == null) {
            this.createdAt = new Timestamp(System.currentTimeMillis());
        }
        this.updatedAt = this.createdAt;
        }
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }
}
