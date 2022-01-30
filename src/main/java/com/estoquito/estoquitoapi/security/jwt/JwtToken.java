package com.estoquito.estoquitoapi.security.jwt;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JwtToken {
    private Long id;
    private String email;
}
