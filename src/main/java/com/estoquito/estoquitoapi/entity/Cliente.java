package com.estoquito.estoquitoapi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "cliente")
public class Cliente {
    @Id
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String cpf_cnpj;
    private LocalDateTime data_registro;
    @ManyToOne
    private Filial filial;
}
