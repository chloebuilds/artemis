package com.artemis.artemis.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@Table(name = "jobs")
public class Job {

    private String jobTitle;

    private String company;

    private String location;

    private String workType;

    private String jobDescription;

    private String salaryRange;

    private String experienceLevel;

    private String techStack;

    private String requirements;

    private String postDate;

    private Boolean archived;

    private Iterable<Job> saved;

}
