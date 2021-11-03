package com.artemis.artemis.services;

import com.artemis.artemis.models.Company;
import com.artemis.artemis.repos.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepo companyRepo;

    public Iterable<Company> findAllJobs() { return companyRepo.findAll(); }

    public Company createCompany(Company company) { return companyRepo.save(company); }

    public Optional<Company> findCompany(Integer companyId) {
        Optional<Company> optCompany = companyRepo.findById(companyId);
        if (optCompany.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found");
        }
        return optCompany;
    }

    public void deleteCompany(Integer companyId) {
        Optional<Company> optCompany = companyRepo.findById(companyId);
        if (optCompany.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found");
        }
        companyRepo.deleteById(companyId);
    }

    public Company updateCompany(Integer companyId, Company company) {
        Optional<Company> optCompany = companyRepo.findById(companyId);
        if (optCompany.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found");
        }
        Company companyToUpdate = optCompany.get();
        companyToUpdate.setCompanyName(company.getCompanyName());
        companyToUpdate.setMission(company.getMission());
        companyToUpdate.setDescription(company.getDescription());
        companyToUpdate.setValues(company.getValues());
        companyToUpdate.setBenefits(company.getBenefits());
        companyToUpdate.setWebsite(company.getWebsite());
        companyToUpdate.setLocation(company.getLocation());
        return companyRepo.save(companyToUpdate);
    }
}
