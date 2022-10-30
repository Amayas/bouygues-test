package com.example.fr.bouygues.converter.roman.validation;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

@Slf4j
public class RomanFormatValidator implements ConstraintValidator<RomanFormatValidation, String> {

    /**
     * Rule :
     * 1 - I, X and C are repeated up to 3 times in succession
     * 2 - only symbols I, X, C, V, L, M, D are expected
     * */
//    private final String limitedOccurrences = "^(I|X|C{0,3})$";

    private final String limitedSymbols = "^[IXCVLMD]+$";

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        // non-null / non-empty check
        if (StringUtils.isBlank(s)) {
            log.error("The given roman number should not be null");
            return false;
        }

        // pattern matching check
        if (!isLimitedConsecutiveSymbols(s) || !Pattern.matches(limitedSymbols, s)) {
            log.error("Bad format for input {}", s);
            return false;
        }
        return true;
    }

    private boolean isLimitedConsecutiveSymbols(String input) {
        char[] array = input.toCharArray();

        char first;
        char second;
        for(int i = 0; i<array.length; i++) {
            if(array.length > 3 && i > 1 && i<array.length-1 && (array[i] == 'I' || array[i] == 'C' || array[i] == 'X')) {
                first = array[i-2];
                second = array[i-1];
                // since we got 4 consecutive values of the monitored symbols -> not valid
                if(first == second && second == array[i] && array[i] == array[i+1])
                    return false;
            }
        }

        return true;
    }
}
