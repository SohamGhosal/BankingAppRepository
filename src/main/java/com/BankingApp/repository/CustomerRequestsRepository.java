package com.BankingApp.repository;

import com.BankingApp.dto.CustomerRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRequestsRepository extends JpaRepository<CustomerRequests,String> {
    public CustomerRequests findByStatusAndEmail(String status,String email);
}
