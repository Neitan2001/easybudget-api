package com.easybudget.easybudget_api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "easybudget.jwt")
@Data
public class JwtProperties {
    private String secret;
    private long expirationMs;
}
