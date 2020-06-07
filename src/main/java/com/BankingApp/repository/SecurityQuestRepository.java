package com.BankingApp.repository;

import com.BankingApp.dto.SecurityQuest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityQuestRepository extends JpaRepository<SecurityQuest,String> {
}
