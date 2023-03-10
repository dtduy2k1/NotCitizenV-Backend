package com.zue.be.controller;

import com.zue.be.entity.custom.Population;
import com.zue.be.payload.CitizenDto;
import com.zue.be.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping("api/v1/citizen")
public class CitizenController {
    @Autowired
    CitizenService citizenService;

    @GetMapping("/")
    public ResponseEntity<List<CitizenDto>> getAll() {
        List<CitizenDto> citizenDtoList = citizenService.getAll();
        return new ResponseEntity<List<CitizenDto>>(citizenDtoList, HttpStatus.OK);
    }

    @GetMapping("/{citizenId}")
    public ResponseEntity<CitizenDto> getById(@PathVariable String citizenId) {
        CitizenDto citizenDto = citizenService.getById(citizenId);
        return new ResponseEntity<>(citizenDto, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<CitizenDto> create(@RequestBody Map<String, Object> citizenJSONInfo) {
        CitizenDto newCitizen = citizenService.createCitizen(citizenJSONInfo);
        return new ResponseEntity<>(newCitizen, HttpStatus.CREATED);
    }

    @PutMapping("/{citizenId}")
    public ResponseEntity<CitizenDto> update(@PathVariable String citizenId, @RequestBody Map<String, Object> citizenJSONInfo) throws NoSuchMethodException, ParseException {
        CitizenDto newCitizen = citizenService.updateCitizen(citizenId, citizenJSONInfo);
        return new ResponseEntity<>(newCitizen, HttpStatus.OK);
    }

    @DeleteMapping("/{citizenId}")
    public ResponseEntity<String> deleteById(@PathVariable String citizenId) {
        return new ResponseEntity<>(citizenService.deleteById(citizenId), HttpStatus.OK);
    }

    @GetMapping("/population")
    public ResponseEntity<Long> getCountryPopulation() {
        Long population = citizenService.getCountryPopulation();
        return new ResponseEntity<Long>(population, HttpStatus.OK);
    }

    @GetMapping("/population/province")
    public ResponseEntity<List<Population>> getPopulationListGroupByProvince() {
        List<Population> population = citizenService.getPopulationListGroupByProvince();
        return new ResponseEntity<List<Population>>(population, HttpStatus.OK);
    }

    @GetMapping("/population/district")
    public ResponseEntity<List<Population>> getPopulationListGroupByDistrict() {
        List<Population> population = citizenService.getPopulationListGroupByDistrict();
        return new ResponseEntity<List<Population>>(population, HttpStatus.OK);
    }

    @GetMapping("/population/ward")
    public ResponseEntity<List<Population>> getPopulationListGroupByWard() {
        List<Population> population = citizenService.getPopulationListGroupByWard();
        return new ResponseEntity<List<Population>>(population, HttpStatus.OK);
    }
}
