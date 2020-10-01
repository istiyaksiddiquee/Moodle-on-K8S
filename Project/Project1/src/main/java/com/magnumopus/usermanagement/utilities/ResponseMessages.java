package com.magnumopus.usermanagement.utilities;

/**
 * As we need to send informative responses to the user,
 * this class will be used for that purpose. Here, we're
 * storing status codes with a short, informative message
 */

public enum ResponseMessages {

    OK("Request has succeeded.", 200),
    CREATED("Requested resource has been created.", 201), // -->  response to POST request
    ACCEPTED("Request is accepted, no further guarantee.", 202),
    PUT_SUCCEEDED("PUT Request successful, no page-redirection needed.", 204),
    BAD_REQUEST("Request is corrupted. Further info: ", 400),
    UNAUTHORIZED("Unauthorized access to resource.", 401),
    FORBIDDEN("Access forbidden.", 403),
    NOT_FOUND("The requested resource is not found.", 404),
    INTERNAL_SERVER_ERROR("Could not Process because of server error. Further info: ", 500),
    NOT_IMPLEMENTED("Requested resource has not yet been implemented. Please contact maintainer.", 500),
    BAD_GATEWAY("Bad gateway error.", 502),
    SERVICE_OUTAGE("Service is not available at this moment.", 503),
    ;

    String label;
    Integer code;

    private ResponseMessages(String label, Integer code) {
        this.label = label;
        this.code = code;
    }

    public static ResponseMessages valueOfCode(Integer code) {
        for (ResponseMessages message : values()) {
            if (message.code.equals(code)) {
                return message;
            }
        }
        return null;
    }
}