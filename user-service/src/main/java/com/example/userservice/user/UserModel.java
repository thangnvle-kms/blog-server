package com.example.userservice.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserModel {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    private String username;
    private String password;
    private Date createdAt;
    private Date deletedAt;
}
