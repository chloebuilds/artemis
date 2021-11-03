package com.artemis.artemis.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "job_title")
    private String jobTitle;

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH
    })
    @JoinColumn(name = "company_id")
    private Company company;

    @Column
    private String location;

    @Column
    private String workType;

    @Column
    private String jobDescription;

    @Column
    private String salaryRange;

    @Column
    private String experienceLevel;

    @Column
    private String techStack;

    @Column
    private String requirements;

    @Column
    private String postDate;

    @Column
    private Boolean archived;

    @ManyToMany(cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH
    })
    @JoinTable(
            name = "user_jobsapplied",
            joinColumns = {@JoinColumn(name = "job_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private List<User> applicants;

}
