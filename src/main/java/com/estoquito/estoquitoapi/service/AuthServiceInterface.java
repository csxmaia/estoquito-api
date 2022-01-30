package com.estoquito.estoquitoapi.service;

import com.estoquito.estoquitoapi.dto.ApiResponseDTO;
import com.estoquito.estoquitoapi.security.jwt.JwtResponse;
import com.estoquito.estoquitoapi.vo.UsuarioVO;

public interface AuthServiceInterface {
    ApiResponseDTO<JwtResponse> login(UsuarioVO usuarioVO);
}
