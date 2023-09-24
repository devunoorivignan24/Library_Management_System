package com.example.Library_Management_System.Repository;

import com.example.Library_Management_System.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
