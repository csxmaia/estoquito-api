package com.estoquito.estoquitoapi.service;

import com.estoquito.estoquitoapi.dto.ApiResponseDTO;
import com.estoquito.estoquitoapi.vo.CategoriaVO;

import java.util.List;

public interface CategoriaServiceInterface {
    ApiResponseDTO<CategoriaVO> save(CategoriaVO categoriaVO);
    ApiResponseDTO<List<CategoriaVO>> getAll();
}
