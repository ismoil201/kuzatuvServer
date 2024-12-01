package com.example.kuzatuv.repository;

import com.example.kuzatuv.model.Sms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmsRepository extends JpaRepository<Sms, Long> {}
