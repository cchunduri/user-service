package com.chaitu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
public record AppUserDto (
    UUID userId,
    String firstName,
    String lastName,
    String email,
    String password,
    Long phoneNumber,
    Integer phoneNumberExt
) { }
