package com.estoquito.estoquitoapi.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String ean;

    @Column
    private String nome;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Marca marca;

    @Column(name = "quantidade_estoque")
    private Double quantidadeEstoque;

    @Column(name = "quantidade_minima")
    private Double quantidadeMinima;

    @Column(name = "tipo_embalagem")
    private String tipoEmbalagem;

    @Column(name = "valor_venda")
    private Double valorVenda;

    @Column
    private String descricao;
}
