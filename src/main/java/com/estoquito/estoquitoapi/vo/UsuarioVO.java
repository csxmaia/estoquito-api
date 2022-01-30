package com.estoquito.estoquitoapi.vo;

import lombok.Data;

@Data
public class UsuarioVO {
    private Long id;
    private String email;
    private String password;
}
