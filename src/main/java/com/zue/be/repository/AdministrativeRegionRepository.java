package com.zue.be.repository;

import com.zue.be.entity.AdministrativeRegion;
import com.zue.be.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdministrativeRegionRepository extends JpaRepository<AdministrativeRegion, Integer> {
    List<AdministrativeRegion> findAll();

    @Override
    Optional<AdministrativeRegion> findById(Integer s);
}
