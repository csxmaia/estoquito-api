package com.estoquito.estoquitoapi.controller;

import com.estoquito.estoquitoapi.dto.ApiResponseDTO;
import com.estoquito.estoquitoapi.service.CategoriaService;
import com.estoquito.estoquitoapi.service.MarcaService;
import com.estoquito.estoquitoapi.vo.CategoriaVO;
import com.estoquito.estoquitoapi.vo.MarcaVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/marca")
public class MarcaController {
    @Autowired
    MarcaService marcaService;

    @PostMapping("/save")
    public ResponseEntity<ApiResponseDTO<MarcaVO>> save(@RequestBody MarcaVO marcaVO) {
        ApiResponseDTO<MarcaVO> apiResponseDTO = marcaService.save(marcaVO);
        return ResponseEntity.status(apiResponseDTO.getStatus()).body(apiResponseDTO);
    }

    @GetMapping()
    public ResponseEntity<ApiResponseDTO<List<MarcaVO>>> getAll() {
        ApiResponseDTO<List<MarcaVO>> apiResponseDTO = marcaService.getAll();
        return ResponseEntity.status(apiResponseDTO.getStatus()).body(apiResponseDTO);
    }
}
