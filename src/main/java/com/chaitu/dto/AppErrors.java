package com.chaitu.dto;

import java.util.List;

public record AppErrors(
        List<String> errors
) { }
