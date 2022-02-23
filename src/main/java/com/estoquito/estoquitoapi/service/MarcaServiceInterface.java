package com.estoquito.estoquitoapi.service;

import com.estoquito.estoquitoapi.dto.ApiResponseDTO;
import com.estoquito.estoquitoapi.vo.MarcaVO;

import java.util.List;

public interface MarcaServiceInterface {
    ApiResponseDTO<MarcaVO> save(MarcaVO marcaVO);
    ApiResponseDTO<List<MarcaVO>> getAll();
}
