package com.BankingApp.repository;

import com.BankingApp.dto.BankUser;
import com.BankingApp.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
    public Customer findByAccountId(String accountId);
}
