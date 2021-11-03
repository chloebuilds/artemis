package com.artemis.artemis.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


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

    private String location;

    private String workType;

    private String jobDescription;

    private String salaryRange;

    private String experienceLevel;

    private String techStack;

    private String requirements;

    private String postDate;

    private Boolean archived;

    @ManyToMany(cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH
    })
    @JoinTable(
            name = "user_jobsapplied",
            joinColumns = {@JoinColumn(name = "job_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private Iterable<User> applicants;

}
