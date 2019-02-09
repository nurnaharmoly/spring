package com.example.webmvcthymeleaf.repository;

import com.example.webmvcthymeleaf.entity.Save;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaveRepo extends JpaRepository<Save, Long> {
}
