package com.artemis.artemis.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto generate my keys for me and treat them as ids
    @Column
    private Integer id;

    @Column
    private String companyName;

    @Column
    private String mission;

    @Column
    private String description;

    @Column
    private String values;

    @Column
    private String benefits;

    @Column
    private String website;

    @Column
    private String location;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @Column
    private List<Job> jobPostings;

}
