package br.com.migration.example.demo.migrations;

import br.com.migration.example.demo.domain.Pessoa;
import br.com.migration.example.demo.repository.PessoaRepository;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static br.com.migration.example.demo.migrations.OrderedMigration.PESSOA_MIGRATION;

@ChangeUnit(
        id = "pessoa-migration",
        order = PESSOA_MIGRATION,
        author = "spring-mongock-example")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaChangeUnit extends BaseChangeUnit {

    private final PessoaRepository repository;

    List<Pessoa> listaPessoas = new ArrayList<>();

    private void criarPessoas() {
        criarPessoa("João", "Silva");
        criarPessoa("José", "Souza");
    }

    private void criarPessoa(String nome, String sobrenome) {
        listaPessoas.add(Pessoa.builder()
                .withNome(nome)
                .withSobrenome(sobrenome)
                .build()
        );
    }

    @Override
    @Execution
    public void changeUnit() {
        criarPessoas();
        repository.saveAll(listaPessoas);
    }

    @Override
    @RollbackExecution
    public void rollback() {
        repository.deleteAll();
    }

}
