package com.zue.be.service;


import com.zue.be.entity.AdministrativeRegion;
import com.zue.be.entity.Citizen;
import com.zue.be.exception.ResourceNotFoundException;
import com.zue.be.payload.AdministrativeRegionDto;
import com.zue.be.payload.CitizenDto;
import com.zue.be.repository.AdministrativeRegionRepository;
import com.zue.be.repository.CitizenRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdministrativeRegionService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private AdministrativeRegionRepository repository;

    public List<AdministrativeRegionDto> getAll() {
        List<AdministrativeRegion> entities = repository.findAll();
        return entities.stream().map(l-> mapper.map(l, AdministrativeRegionDto.class)).collect(Collectors.toList());
    }

    public AdministrativeRegionDto getById(String admRegionId) {
        AdministrativeRegion ad = repository.findById(Integer.parseInt(admRegionId)).orElseThrow(
                () -> new ResourceNotFoundException("AdmRegion", "admRegionId", Long.parseLong(admRegionId)));
        return mapper.map(ad, AdministrativeRegionDto.class);
    }
}
