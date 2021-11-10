package com.estoquito.estoquitoapi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "filial")
public class Filial {
    @Id
    private Long id;
    private String nome;
    @ManyToOne
    private Cidade cidade;
}
