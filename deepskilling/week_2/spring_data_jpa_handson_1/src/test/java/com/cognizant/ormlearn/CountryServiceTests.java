package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CountryServiceTests {
    @Autowired
    private CountryService countryService;

    @Test
    void countryCrudWorks() throws Exception {
        countryService.addCountry(new Country("JP", "Japan"));
        assertEquals("Japan", countryService.findCountryByCode("JP").getName());
        countryService.updateCountry("JP", "Japan Updated");
        assertEquals("Japan Updated", countryService.findCountryByCode("JP").getName());
        assertFalse(countryService.findCountriesByNameContaining("Japan").isEmpty());
        countryService.deleteCountry("JP");
        assertThrows(CountryNotFoundException.class, () -> countryService.findCountryByCode("JP"));
    }
}
