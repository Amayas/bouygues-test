package com.example.fr.bouygues.converter.roman.service;

public abstract class AbstractRomanToNumericConverter {

    /**
     * Maps a roman unit symbol to it's numeric value
     * */
    protected int getRomanUnitNumericValue (char r) {
        switch (r) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
