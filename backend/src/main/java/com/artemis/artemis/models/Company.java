package com.artemis.artemis.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto generate my keys for me and treat them as ids
    private Integer id;

    private String companyName;

    private String mission;

    private String description;

    private String values;

    private String benefits;

    private String website;

    private String location;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Iterable<Job> jobPostings;

}
