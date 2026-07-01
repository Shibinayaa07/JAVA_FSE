package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrmLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");
    }

    @Bean
    CommandLineRunner runCountryHandsOn(CountryService countryService) {
        return args -> {
            countryService.addCountry(new Country("IN", "India"));
            countryService.addCountry(new Country("US", "United States"));
            countryService.addCountry(new Country("FR", "France"));
            LOGGER.debug("countries={}", countryService.getAllCountries());
            LOGGER.debug("country={}", countryService.findCountryByCode("IN"));
            countryService.updateCountry("FR", "French Republic");
            LOGGER.debug("matching={}", countryService.findCountriesByNameContaining("Uni"));
            countryService.deleteCountry("US");
        };
    }
}
