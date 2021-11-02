package com.artemis.artemis.models;


import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column (name = "username", nullable = false)
    @NotEmpty(message = "You need a username")
    @NotNull
    private String username;

    private String email;

    private String password;

    private String linkedin;

    private String github;

    private String portfolio;

    private Integer jobsApplied;

    private Integer jobsSaved;

}
