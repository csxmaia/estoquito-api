package com.estoquito.estoquitoapi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "material")
public class Material {
    @Id
    private Long id;
    private String nome;
    private String tipo;
    private Long quantidade;
    private LocalDateTime data_estoque;
    private String cor;
    private String altura;
    private String comprimento;
    private String potencia;
    private String modelo;
    @ManyToOne
    private Filial filial;
}
