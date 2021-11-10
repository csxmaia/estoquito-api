package com.estoquito.estoquitoapi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "funcionario")
public class Funcionario {
    @Id
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String cpf;
    @ManyToOne
    private Filial filial;
}
