package com.estoquito.estoquitoapi.service;

import com.estoquito.estoquitoapi.dto.ApiResponseDTO;
import com.estoquito.estoquitoapi.entity.Produto;
import com.estoquito.estoquitoapi.exception.InfoException;
import com.estoquito.estoquitoapi.repository.ProdutoRepository;
import com.estoquito.estoquitoapi.vo.ProdutoVO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProdutoService implements ProdutoServiceInterface {

    @Autowired
    ProdutoRepository produtoRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ApiResponseDTO<ProdutoVO> save(ProdutoVO produtoVO) {
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        try {
            Produto produto = objectMapper.convertValue(produtoVO, Produto.class);

            produtoRepository.save(produto);
            ProdutoVO produtoVOResponse = objectMapper.convertValue(produto, ProdutoVO.class);

            apiResponseDTO.setData(produtoVOResponse);
            apiResponseDTO.setStatus(HttpStatus.OK);
            apiResponseDTO.setMessage("Produto cadastrado com sucesso");

            return apiResponseDTO;
        } catch (Exception e) {
            log.error("ProdutoService; save; -> " + e);
            apiResponseDTO.setMessage("Erro ao cadastrar Produto");
            apiResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return apiResponseDTO;
        }
    }

    @Override
    public ApiResponseDTO<ProdutoVO> edit(ProdutoVO produtoVO) {
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        try {
            Produto produto = objectMapper.convertValue(produtoVO, Produto.class);

            produtoRepository.save(produto);
            ProdutoVO produtoVOResponse = objectMapper.convertValue(produto, ProdutoVO.class);

            apiResponseDTO.setData(produtoVOResponse);
            apiResponseDTO.setStatus(HttpStatus.OK);
            apiResponseDTO.setMessage("Produto editado com sucesso");

            return apiResponseDTO;
        } catch (Exception e) {
            log.error("ProdutoService; edit; -> " + e);
            apiResponseDTO.setMessage("Erro ao editar Produto");
            apiResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return apiResponseDTO;
        }
    }

    @Override
    public ApiResponseDTO<List<ProdutoVO>> getAll() {
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        try {
            List<Produto> produtoList = produtoRepository.findAll();

            List<ProdutoVO> produtoVOList = objectMapper.convertValue(produtoList, new TypeReference<List<ProdutoVO>>() {});

            apiResponseDTO.setData(produtoVOList);
            apiResponseDTO.setStatus(HttpStatus.OK);

            return apiResponseDTO;
        } catch (Exception e) {
            log.error("ProdutoService; getAll; -> " + e);
            apiResponseDTO.setMessage("Erro ao listar Produtos");
            apiResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return apiResponseDTO;
        }
    }

    @Override
    public ApiResponseDTO<ProdutoVO> getById(Long id) {
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        try {
            Optional<Produto> produto = produtoRepository.findById(id);

            if(produto.isEmpty()){
                throw new InfoException("Produto não encontrado", HttpStatus.NOT_FOUND);
            }

            ProdutoVO produtoVO = objectMapper.convertValue(produto.get(), ProdutoVO.class);

            apiResponseDTO.setData(produtoVO);
            apiResponseDTO.setStatus(HttpStatus.OK);

            return apiResponseDTO;

        } catch (InfoException e) {
            apiResponseDTO.setStatus(e.getStatus());
            apiResponseDTO.setMessage(e.getMessage());
            return apiResponseDTO;
        } catch (Exception e) {
            log.error("ProdutoService; getById; -> " + e);
            apiResponseDTO.setMessage("Erro ao buscar Produto");
            apiResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return apiResponseDTO;
        }
    }
}
