package com.example.supermarket.repository;

import com.example.supermarket.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorRepository extends JpaRepository<Sector, String> {
}
