package com.zue.be.service;

import com.zue.be.entity.Ward;
import com.zue.be.payload.WardDto;
import com.zue.be.repository.WardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WardService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private WardRepository repository;

    public List<WardDto> getAll() {
        List<Ward> entities = repository.findAll();
        return entities.stream().map(l-> mapper.map(l, WardDto.class)).collect(Collectors.toList());
    }
}
