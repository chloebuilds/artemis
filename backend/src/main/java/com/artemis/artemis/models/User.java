package com.artemis.artemis.models;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

import javax.persistence.*;
import java.util.List;

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

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String linkedin;

    @Column
    private String github;

    @Column
    private String portfolio;

    @ManyToMany(cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH
    })
    @JoinTable(
            name = "user_jobsapplied",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "job_id")}
    )
    private List<Job> jobsApplied;

    @ManyToMany(cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH
    })
    @JoinTable(
            name = "user_jobssaved",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "job_id")}
    )
    private List<Job> jobsSaved;

}
