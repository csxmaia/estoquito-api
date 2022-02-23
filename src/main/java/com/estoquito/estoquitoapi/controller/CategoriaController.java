package com.estoquito.estoquitoapi.controller;

import com.estoquito.estoquitoapi.dto.ApiResponseDTO;
import com.estoquito.estoquitoapi.service.CategoriaService;
import com.estoquito.estoquitoapi.vo.CategoriaVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/categoria")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @PostMapping("/save")
    public ResponseEntity<ApiResponseDTO<CategoriaVO>> save(@RequestBody CategoriaVO categoriaVO) {
        ApiResponseDTO<CategoriaVO> apiResponseDTO = categoriaService.save(categoriaVO);
        return ResponseEntity.status(apiResponseDTO.getStatus()).body(apiResponseDTO);
    }

    @GetMapping()
    public ResponseEntity<ApiResponseDTO<List<CategoriaVO>>> getAll() {
        ApiResponseDTO<List<CategoriaVO>> apiResponseDTO = categoriaService.getAll();
        return ResponseEntity.status(apiResponseDTO.getStatus()).body(apiResponseDTO);
    }
}
