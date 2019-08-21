package com.senior.cadastro.pessoa.repositories;

import com.senior.cadastro.pessoa.models.Pessoa;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
    List<Pessoa> findByNomeContaining(String nome, Pageable pageable);
    Long countPessoaByNomeContaining(String nome);
}
