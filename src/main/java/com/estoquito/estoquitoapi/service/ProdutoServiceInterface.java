package com.estoquito.estoquitoapi.service;

import com.estoquito.estoquitoapi.dto.ApiResponseDTO;
import com.estoquito.estoquitoapi.vo.ProdutoVO;

import java.util.List;

public interface ProdutoServiceInterface {
    ApiResponseDTO<ProdutoVO> save(ProdutoVO produtoVO);
    ApiResponseDTO<ProdutoVO> edit(ProdutoVO produtoVO);
    ApiResponseDTO<List<ProdutoVO>> getAll();
    ApiResponseDTO<ProdutoVO> getById(Long id);
}
