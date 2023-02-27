package com.zue.be.controller;
import com.zue.be.payload.WardDto;
import com.zue.be.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping("api/v1/ward")
public class WardController {
    @Autowired
    WardService wardService;

    @GetMapping("/")
    public ResponseEntity<List<WardDto>> getAll() {
        List<WardDto> wardDtoList = wardService.getAll();
        return new ResponseEntity<List<WardDto>>(wardDtoList, HttpStatus.OK);
    }

    /*@GetMapping("/{provinceId}")
    public ResponseEntity<ProvinceDto> getById(@PathVariable String provinceId) {
        ProvinceDto provinceDto = wardService.getById(provinceId);
        return new ResponseEntity<>(provinceDto, HttpStatus.OK);
    }*/
}