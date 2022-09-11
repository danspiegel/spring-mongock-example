package br.com.migration.example.demo.repository;

import br.com.migration.example.demo.domain.Pessoa;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends MongoRepository<Pessoa, ObjectId> {



}
