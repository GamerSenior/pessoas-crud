package com.senior.cadastro.pessoa;

import com.senior.cadastro.pessoa.models.Contato;
import com.senior.cadastro.pessoa.models.Endereco;
import com.senior.cadastro.pessoa.models.Pessoa;
import com.senior.cadastro.pessoa.repositories.PessoaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PessoaRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Test
    public void testBuscarPorNome() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Giovani Garcia Abel");
        pessoa.setIdade(22);

        Endereco endereco = new Endereco();
        endereco.setCep(18681120L);
        endereco.setLogradouro("Rua Bartolomeu Bueno da Silva");
        endereco.setNumero(473L);
        endereco.setTipoEndereco("Rua");
        pessoa.setEndereco(endereco);

        List<Contato> contatos = new ArrayList<>();
        Contato contato1 = new Contato();
        contato1.setDdd(14);
        contato1.setDdi(51);
        contato1.setNumero(997596962L);
        contatos.add(contato1);

        Contato contato2 = new Contato();
        contato2.setDdi(51);
        contato2.setDdd(14);
        contato2.setNumero(32648976L);
        contatos.add(contato2);
        pessoa.setContatos(contatos);

        entityManager.persist(pessoa);

        Pageable primeiraPagina = PageRequest.of(0, 10);
        List<Pessoa> pessoas = pessoaRepository.findByNomeContaining("Giovani", primeiraPagina);

        Assert.assertEquals(1, pessoas.size());
        Assert.assertNotNull(pessoas.get(0));
        Pessoa pessoa1 = pessoas.get(0);
        Assert.assertEquals("Giovani Garcia Abel", pessoa1.getNome());
        Assert.assertNotNull(pessoa1.getEndereco());
        Assert.assertEquals("Rua Bartolomeu Bueno da Silva", pessoa1.getEndereco().getLogradouro());
        Assert.assertEquals(2, pessoa1.getContatos().size());
    }
}

