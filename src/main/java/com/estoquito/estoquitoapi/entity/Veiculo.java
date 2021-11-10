package com.estoquito.estoquitoapi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "veiculo")
public class Veiculo {
    @Id
    private Long id;
    private String placa;
}
