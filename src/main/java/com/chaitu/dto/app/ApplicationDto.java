package com.chaitu.dto.app;

import java.util.UUID;

public record ApplicationDto(
        UUID appId,
        String appName,
        String appDesc
) {
}
