package com.estoquito.estoquitoapi.service;

import com.estoquito.estoquitoapi.dto.ApiResponseDTO;
import com.estoquito.estoquitoapi.entity.Categoria;
import com.estoquito.estoquitoapi.repository.CategoriaRepository;
import com.estoquito.estoquitoapi.vo.CategoriaVO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoriaService implements CategoriaServiceInterface {

    @Autowired
    CategoriaRepository categoriaRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ApiResponseDTO<CategoriaVO> save(CategoriaVO categoriaVO) {
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        try {
            Categoria categoria = objectMapper.convertValue(categoriaVO, Categoria.class);

            categoriaRepository.save(categoria);
            CategoriaVO categoriaVOResponse = objectMapper.convertValue(categoria, CategoriaVO.class);

            apiResponseDTO.setData(categoriaVOResponse);
            apiResponseDTO.setStatus(HttpStatus.OK);
            apiResponseDTO.setMessage("Categoria cadastrada com sucesso");

            return apiResponseDTO;
        } catch (Exception e) {
            log.error("CategoriaService; save; -> " + e);
            apiResponseDTO.setMessage("Erro ao cadastrar Categoria");
            apiResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return apiResponseDTO;
        }
    }

    @Override
    public ApiResponseDTO<List<CategoriaVO>> getAll() {
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        try {
            List<Categoria> categoriaList = categoriaRepository.findAll();

            List<CategoriaVO> categoriaVOList = objectMapper.convertValue(categoriaList, new TypeReference<List<CategoriaVO>>() {});

            apiResponseDTO.setData(categoriaVOList);
            apiResponseDTO.setStatus(HttpStatus.OK);

            return apiResponseDTO;
        } catch (Exception e) {
            log.error("CategoriaService; getAll; -> " + e);
            apiResponseDTO.setMessage("Erro ao listar Categorias");
            apiResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return apiResponseDTO;
        }
    }
}
