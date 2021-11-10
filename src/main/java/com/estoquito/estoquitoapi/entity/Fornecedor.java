package com.estoquito.estoquitoapi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "fornecedor")
public class Fornecedor {
    @Id
    private Long id;
    private String nome;
    @ManyToOne
    private Cidade cidade;
    @ManyToOne
    private Material material;
    private Double preco;
    private String telefone;
}
