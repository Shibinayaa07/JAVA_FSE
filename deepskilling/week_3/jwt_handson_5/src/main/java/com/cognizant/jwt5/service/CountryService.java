package com.cognizant.jwt5.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.jwt5.model.Country;

@Service
public class CountryService {

    private final List<Country> countries = List.of(
            new Country("US", "United States"),
            new Country("DE", "Germany"),
            new Country("IN", "India"),
            new Country("JP", "Japan"));

    public List<Country> getAllCountries() {
        return new ArrayList<>(countries);
    }
}