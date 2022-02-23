package com.estoquito.estoquitoapi.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String nome;
    
    @Column
    private String descricao;
}
