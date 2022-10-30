package com.example.fr.bouygues.converter.roman.rest;

import com.example.fr.bouygues.converter.roman.service.RomanToNumericConverter;
import com.example.fr.bouygues.converter.roman.validation.RomanFormatValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Validated
public class RomanNumberConverterController {

    private final RomanToNumericConverter romanToNumericConverter;

    @Autowired
    public RomanNumberConverterController(RomanToNumericConverter romanToNumericConverter) {
        this.romanToNumericConverter = romanToNumericConverter;
    }

    @GetMapping("/{roman}")
    public Mono<Integer> romanNumberToNumeric(@PathVariable @RomanFormatValidation String roman) {
        return Mono.fromSupplier(() -> romanToNumericConverter.romanToNumeric(roman));
    }

}
