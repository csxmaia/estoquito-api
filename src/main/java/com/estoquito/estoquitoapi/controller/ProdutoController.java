package com.estoquito.estoquitoapi.controller;

import com.estoquito.estoquitoapi.dto.ApiResponseDTO;
import com.estoquito.estoquitoapi.service.ProdutoService;
import com.estoquito.estoquitoapi.vo.ProdutoVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/produto")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @PostMapping("/save")
    public ResponseEntity<ApiResponseDTO<ProdutoVO>> save(@RequestBody ProdutoVO produtoVO) {
        ApiResponseDTO<ProdutoVO> apiResponseDTO = new ApiResponseDTO();
        if(produtoVO.getId() == null) {
            apiResponseDTO = produtoService.save(produtoVO);
        } else {
            apiResponseDTO = produtoService.save(produtoVO);
        }
        return ResponseEntity.status(apiResponseDTO.getStatus()).body(apiResponseDTO);
    }

    @GetMapping()
    public ResponseEntity<ApiResponseDTO<List<ProdutoVO>>> getAll() {
        ApiResponseDTO<List<ProdutoVO>> apiResponseDTO = produtoService.getAll();
        return ResponseEntity.status(apiResponseDTO.getStatus()).body(apiResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<ProdutoVO>> getById(@PathVariable Long id) {
        ApiResponseDTO<ProdutoVO> apiResponseDTO = produtoService.getById(id);
        return ResponseEntity.status(apiResponseDTO.getStatus()).body(apiResponseDTO);
    }
}
