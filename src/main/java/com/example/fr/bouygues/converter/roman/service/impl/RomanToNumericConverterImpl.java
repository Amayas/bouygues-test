package com.example.fr.bouygues.converter.roman.service.impl;

import com.example.fr.bouygues.converter.roman.service.AbstractRomanToNumericConverter;
import com.example.fr.bouygues.converter.roman.service.RomanToNumericConverter;
import org.springframework.stereotype.Service;

/**
 * A roman number converter
 * */
@Service
public class RomanToNumericConverterImpl extends AbstractRomanToNumericConverter implements RomanToNumericConverter {

    /**
     * Converts a roman number into it's corresponding numeric value
     * @param romanNumber : the roman number input
     * */
    @Override
    public int romanToNumeric(String romanNumber) {

        char[] romanSymbols = romanNumber.toCharArray();
        int convertedValue = 0;
        // single roman symbol
        if(romanSymbols.length == 1)
            return getRomanUnitNumericValue(romanSymbols[0]);

        // if current item's value is less than the next one's, substract it from final sum
        // else , add it
        for(int i=0; i<romanSymbols.length; i++) {
            if(i < romanSymbols.length-1 && getRomanUnitNumericValue(romanSymbols[i]) < getRomanUnitNumericValue(romanSymbols[i+1]))
                convertedValue = convertedValue - getRomanUnitNumericValue(romanSymbols[i]);
            else
                convertedValue = convertedValue + getRomanUnitNumericValue(romanSymbols[i]);
        }

        return convertedValue;
    }
}
