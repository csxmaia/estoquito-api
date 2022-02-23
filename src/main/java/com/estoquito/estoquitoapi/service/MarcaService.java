package com.estoquito.estoquitoapi.service;

import com.estoquito.estoquitoapi.dto.ApiResponseDTO;
import com.estoquito.estoquitoapi.entity.Marca;
import com.estoquito.estoquitoapi.repository.MarcaRepository;
import com.estoquito.estoquitoapi.vo.MarcaVO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@Slf4j
public class MarcaService implements MarcaServiceInterface {

    @Autowired
    MarcaRepository marcaRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ApiResponseDTO<MarcaVO> save(MarcaVO marcaVO) {
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        try {
            Marca marca = objectMapper.convertValue(marcaVO, Marca.class);
            marca.setNome(marca.getNome().toUpperCase());
            marcaRepository.save(marca);

            MarcaVO marcaVOResponse = objectMapper.convertValue(marca, MarcaVO.class);

            apiResponseDTO.setData(marcaVOResponse);
            apiResponseDTO.setStatus(HttpStatus.OK);
            apiResponseDTO.setMessage("Marca cadastrada com sucesso");

            return apiResponseDTO;
        } catch (Exception e) {
            log.error("MarcaService; save; -> " + e);
            apiResponseDTO.setMessage("Erro ao cadastrar Marcas");
            apiResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return apiResponseDTO;
        }
    }

    @Override
    public ApiResponseDTO<List<MarcaVO>> getAll() {
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        try {
            List<Marca> marcaList = marcaRepository.findAll();

            List<MarcaVO> marcaVOList = objectMapper.convertValue(marcaList, new TypeReference<List<MarcaVO>>() {});

            apiResponseDTO.setData(marcaVOList);
            apiResponseDTO.setStatus(HttpStatus.OK);

            return apiResponseDTO;
        } catch (Exception e) {
            log.error("MarcaService; getAll; -> " + e);
            apiResponseDTO.setMessage("Erro ao listar Marcas");
            apiResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return apiResponseDTO;
        }
    }
}
