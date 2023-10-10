package com.example.open_api_test.email.repository;

import com.example.open_api_test.email.domain.AuthCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthCodeRepository extends JpaRepository<AuthCode, String> {
}
