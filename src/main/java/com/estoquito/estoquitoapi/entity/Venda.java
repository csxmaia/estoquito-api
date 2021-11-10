package com.estoquito.estoquitoapi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "venda")
public class Venda {
    @Id
    private Long id;
    private LocalDateTime dataVenda;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Funcionario funcionario;
    @ManyToOne
    private Material material;
    private Long quantidade;
    private Double valor;
    @ManyToOne
    private FormaPagamento formaPagamento;
    @ManyToOne
    private Entrega entrega;
    @ManyToOne
    private Filial filial;
}
