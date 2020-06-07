package com.BankingApp.repository;

import com.BankingApp.dto.ServiceTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceTrackerRepository extends JpaRepository<ServiceTracker,String> {
public List<ServiceTracker>findByAccountId(String accountId);
}
