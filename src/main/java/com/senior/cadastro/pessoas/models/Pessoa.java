package com.senior.cadastro.pessoas.models;

import com.senior.cadastro.pessoas.models.Contato;
import com.senior.cadastro.pessoas.models.Endereco;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Integer idade;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @ManyToMany
    @JoinColumn(name = "pessoa_id")
    private List<Contato> contatos;
}
