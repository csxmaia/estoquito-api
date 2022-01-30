package com.estoquito.estoquitoapi.service;

import com.estoquito.estoquitoapi.dto.ApiResponseDTO;
import com.estoquito.estoquitoapi.entity.Usuario;
import com.estoquito.estoquitoapi.security.jwt.JwtResponse;
import com.estoquito.estoquitoapi.security.jwt.JwtToken;
import com.estoquito.estoquitoapi.security.jwt.TokenService;
import com.estoquito.estoquitoapi.vo.UsuarioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements AuthServiceInterface {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @Override
    public ApiResponseDTO<JwtResponse> login(UsuarioVO usuarioVO) {
        ApiResponseDTO<JwtResponse> apiResponseDTO = new ApiResponseDTO();

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(usuarioVO.getEmail(), usuarioVO.getPassword());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        Usuario user = tokenService.getUserFromToken();

        JwtToken jwtToken = new JwtToken();
        jwtToken.setId(user.getId());
        jwtToken.setEmail(user.getEmail());
        String jwt = tokenService.generateToken(jwtToken);

        JwtResponse jwtResponse = JwtResponse.builder()
                .accessToken(jwt)
                .expiresIn(tokenService.getExpirationSecondsFromToken(jwt))
                .userId(user.getId())
                .build();

        apiResponseDTO.setData(jwtResponse);
        apiResponseDTO.setMessage("Login realizado com sucesso!");
        apiResponseDTO.setStatus(HttpStatus.OK);
        return apiResponseDTO;
    }
}
