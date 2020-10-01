package com.magnumopus.usermanagement.utilities;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class InputValidator {

    public Integer validateInteger(String givenString){

        Integer extractedInteger = null;

        if(givenString == null) {
            return extractedInteger;
        } else if (givenString.isEmpty()) {
            return extractedInteger;
        } else if (StringUtils.isAlphanumeric(givenString.trim().toLowerCase())) {
            extractedInteger = Integer.parseInt(givenString);
        }

        return extractedInteger;
    }
}
