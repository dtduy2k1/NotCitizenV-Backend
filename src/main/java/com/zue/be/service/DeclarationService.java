package com.zue.be.service;

import com.zue.be.entity.Declaration;
import com.zue.be.payload.DeclarationDto;
import com.zue.be.repository.DeclarationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeclarationService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private DeclarationRepository repository;

    public List<DeclarationDto> getAll() {
        List<Declaration> entities = repository.findAll();
        return entities.stream().map(l-> mapper.map(l, DeclarationDto.class)).collect(Collectors.toList());
    }
}
