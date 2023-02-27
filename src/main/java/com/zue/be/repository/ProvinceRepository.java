package com.zue.be.repository;

import com.zue.be.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, String> {
    @Override
    List<Province> findAll();

    @Override
    Optional<Province> findById(String s);


}
