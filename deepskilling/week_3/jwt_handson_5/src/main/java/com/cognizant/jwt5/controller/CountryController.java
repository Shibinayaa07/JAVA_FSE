package com.cognizant.jwt5.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.jwt5.model.Country;
import com.cognizant.jwt5.service.CountryService;

@RestController
public class CountryController {

    private final CountryService countryService = new CountryService();

    @GetMapping("/countries")
    public List<Country> getCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/admin")
    public String adminMessage() {
        return "Admin access granted";
    }
}