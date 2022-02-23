package com.estoquito.estoquitoapi.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "marca")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String nome;

    @Column
    private String descricao;
}
