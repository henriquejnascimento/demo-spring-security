package com.henriquenascimento.springsecurity.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("demo-spring-security.jwt")
public class JwtProperties {

    private Long expiresIn;
    private String issuer;

}
