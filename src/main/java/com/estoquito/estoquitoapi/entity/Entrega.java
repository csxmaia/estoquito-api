package com.estoquito.estoquitoapi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "entrega")
public class Entrega {
    @Id
    private Long id;
    @ManyToOne
    private Veiculo veiculo;
    @ManyToOne
    private Funcionario funcionario;
    private LocalDateTime dataEntrega;
    private Long numeroDeEntregas;
    private Boolean assinatura;
}
