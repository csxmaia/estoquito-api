package com.estoquito.estoquitoapi.vo;

import lombok.Data;

@Data
public class ProdutoVO {
    private Long id;
    private String ean;
    private String nome;
    private Double quantidadeEstoque;
    private Double quantidadeMinima;
    private String tipoEmbalagem;
    private Double valorVenda;
    private String descricao;
    private MarcaVO marca;
    private CategoriaVO categoria;
}
