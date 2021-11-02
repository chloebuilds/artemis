package com.artemis.artemis.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "users")
public class JobApplication {

    private Integer userId;

    private Integer jobId;

}
