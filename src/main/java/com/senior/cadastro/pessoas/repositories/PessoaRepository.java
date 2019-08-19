package com.senior.cadastro.pessoas.repositories;

import com.senior.cadastro.pessoas.models.Pessoa;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
    List<Pessoa> findByNomeContaining(String nome, Pageable pageable);
}
