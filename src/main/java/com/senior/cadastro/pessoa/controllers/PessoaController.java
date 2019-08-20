package com.senior.cadastro.pessoa.controllers;

import com.senior.cadastro.pessoa.models.TesteDTO;
import com.senior.cadastro.pessoa.repositories.PessoaRepository;
import com.senior.cadastro.pessoa.models.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public List<Pessoa> buscarTodos() {
        return StreamSupport
                .stream(pessoaRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @GetMapping(params = {"page", "size", "nome"})
    public List<Pessoa> buscarPorNome(@RequestParam("page") int pagina, @RequestParam("size") int size,
                                      @RequestParam("nome") String nome) {
        return pessoaRepository.findByNomeContaining(nome, PageRequest.of(pagina, size));
    }

    @PostMapping(path = "/inserir")
    public ResponseEntity cadastrar(@RequestBody Pessoa pessoa) {
        try {
            pessoaRepository.save(pessoa);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e);
        }
    }

    @PostMapping("/teste")
    public String teste(@RequestBody TesteDTO dto){
        System.out.println(dto);
        return null;
    }

    @GetMapping("/teste")
    public TesteDTO testeGet() {
        return new TesteDTO("Pamonha", 22);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void deletar(@PathVariable Long id) {
        pessoaRepository.deleteById(id);
    }
}