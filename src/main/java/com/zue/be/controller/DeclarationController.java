package com.zue.be.controller;

import com.zue.be.payload.DeclarationDto;
import com.zue.be.service.DeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping("api/v1/declaration")
public class DeclarationController {
    @Autowired
    DeclarationService declarationService;

    @GetMapping("/")
    public ResponseEntity<List<DeclarationDto>> getAll() {
        List<DeclarationDto> declarationDtoList = declarationService.getAll();
        return new ResponseEntity<List<DeclarationDto>>(declarationDtoList, HttpStatus.OK);
    }

    /*@GetMapping("/{provinceId}")
    public ResponseEntity<ProvinceDto> getById(@PathVariable String provinceId) {
        ProvinceDto provinceDto = declarationService.getById(provinceId);
        return new ResponseEntity<>(provinceDto, HttpStatus.OK);
    }*/
}
