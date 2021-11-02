package com.artemis.artemis.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "companies")
public class Company {

    private Integer id;

    private String companyName;

    private String mission;

    private String description;

    private String values;

    private String benefits;

    private String website;

    private String location;

    private Iterable<User> applicants;

}
