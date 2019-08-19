package com.senior.cadastro.pessoas;

import com.senior.cadastro.pessoas.models.Pessoa;
import com.senior.cadastro.pessoas.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping(method = RequestMethod.POST, path = "/")
    public String cadastrar(Pessoa pessoa) {
        try {
            pessoaRepository.save(pessoa);
            return "Salvo com sucesso";
        } catch (Exception e) {
            return "Erro ao salvar entidade";
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void deletar(@PathVariable Long id) {
        pessoaRepository.deleteById(id);
    }
}