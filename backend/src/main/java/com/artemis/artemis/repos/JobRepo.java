package com.artemis.artemis.repos;

import com.artemis.artemis.models.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepo extends CrudRepository<Job, Integer> {
}
