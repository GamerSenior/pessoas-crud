package com.senior.cadastro.pessoa.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
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
