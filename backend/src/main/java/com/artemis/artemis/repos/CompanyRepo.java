package com.artemis.artemis.repos;

import com.artemis.artemis.models.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepo extends CrudRepository<Company, Integer> {
}
