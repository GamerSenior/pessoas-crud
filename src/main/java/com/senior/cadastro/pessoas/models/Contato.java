package com.senior.cadastro.pessoas.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long pessoa_id;
    private Integer ddi;
    private Integer ddd;
    private Long numero;
    private Long ramal;
}
